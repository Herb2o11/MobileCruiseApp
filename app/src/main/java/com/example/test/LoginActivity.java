package com.example.test;

import android.content.Context;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    CruiseDatabase cruiseDatabase;
    EditText txtEmail, txtPassword;
    Button btnOnSignup, btnOnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cruiseDatabase = CruiseDatabase.getInstance(getApplicationContext());

        txtEmail = findViewById(R.id.etLoginConfirm);
        txtPassword = findViewById(R.id.etPasswordLogIn);
        btnOnSignup = (Button) findViewById(R.id.btnSignUpLogPage);
        btnOnLogin = findViewById(R.id.btnLogInPage);

        btnOnLogin.setOnClickListener(this);
        btnOnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUpLogPage:
                onBtnSignUpClick(v);
                break;
            case R.id.btnLogInPage:
                onBtnLoginClick(v);
                break;
        }
    }

    private void onBtnSignUpClick(View v) {
        Intent it = new Intent(this, Register.class);
        startActivity(it);
    }

    private void onBtnLoginClick(View v) {
        User user = cruiseDatabase.userDao().getUser(txtEmail.getText().toString());
        if(user != null) {
            if(user.getPassword().equals(txtPassword.getText().toString())) {
                Intent goPage2 = new Intent(LoginActivity.this, PageSelectionActivity.class);
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                        getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putLong("ID", user.getId());
                editor.commit();
                startActivity(goPage2);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Wrong Email or Password. ", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(LoginActivity.this, "Wrong Email or Password. ", Toast.LENGTH_LONG).show();
        }
    }
}

