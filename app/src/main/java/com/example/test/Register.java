package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cruiseapp.db.CruiseDatabase;
import com.example.cruiseapp.db.entities.User;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText etEmail, etPassword, etConfirmPassword, etName, etPhone, etAddress;
    Button btnSignUp;

    CruiseDatabase cruiseDatabase;

    Boolean isEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cruiseDatabase = CruiseDatabase.getInstance(getApplicationContext());
        Intent i = getIntent();
        if (i != null)
            isEdit = i.getBooleanExtra("isEdit", false);
        //If is edit change the theme before the view is created
        if (isEdit)
            setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp:
                onBtnSignUp(v);
                break;
        }
    }

    private void onBtnSignUp(View v) {
        String getEmailStr=etEmail.getText().toString();
        String getPasswordStr=etPassword.getText().toString();
        String getPasswordConfStr=etConfirmPassword.getText().toString();
        String getNameStr=etName.getText().toString();
        String getPhone=etPhone.getText().toString();
        String getAddressStr=etAddress.getText().toString();
        //implemented to pass the data
        User user = new User();
        if (getPasswordStr.equals(getPasswordConfStr)){
            user.setEmail(getEmailStr);
            user.setPassword(getPasswordStr);
            user.setPasswordConfirmation(getPasswordConfStr);
            user.setName(getNameStr);
            user.setPhone(getPhone);
            user.setAddress(getAddressStr);

            cruiseDatabase.userDao().insertUser(user);
            SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
            sharedPreferences.edit().clear().commit();

            Intent intent = new Intent(Register.this, PageSelectionActivity.class);



            startActivity(intent);
            finish();
            Toast.makeText(Register.this,"Registration Completed",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(Register.this,"Password is not matching",Toast.LENGTH_LONG).show();
        }
    }
}
