package com.example.test;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    TextInputLayout tiEmail, tiPassword, tiConfirmPassword, tiName, tiPhone, tiAddress, tiEmailRecommend;
    EditText etEmail, etPassword, etConfirmPassword, etName, etPhone, etAddress;
    Button btnSubmit;

    Boolean isEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionbar = getSupportActionBar();
        getSupportActionBar().setTitle("Disney Cruise");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.icon_disneycastleb_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

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
        btnSubmit = findViewById(R.id.btnSingUpPage);

        final UserDAO userDAO = new UserDAO(Register.this);

        userDAO.getAllUsers();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getEmailStr=etEmail.getText().toString();
                String getPasswordStr=etPassword.getText().toString();
                String getPasswordConfStr=etConfirmPassword.getText().toString();
                String getNameStr=etName.getText().toString();
                long getPhone=Long.parseLong(etPhone.getText().toString());
                String getAddressStr=etAddress.getText().toString();

                //implemented to pass the data
                User user = new User();
                user.setEmail(getEmailStr);
                user.setPassword(getPasswordStr);
                user.setPasswordConfirmation(getPasswordConfStr);
                user.setName(getNameStr);
                user.setPhone(getPhone);
                user.setAddress(getAddressStr);

                long savedId = userDAO.registerUser(user);
                Log.d("REGISTER", String.valueOf(savedId));

                Toast.makeText(Register.this,"Registration Completed",Toast.LENGTH_LONG).show();

                Intent ii = new Intent(Register.this,Page2.class);
                startActivity(ii);
                finish();
            }
        });
    }
}
