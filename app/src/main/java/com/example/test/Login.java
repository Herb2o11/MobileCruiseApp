package com.example.test;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextInputLayout tiEmail, tiPassword;
    EditText etEmail, etPassword;
    Validation validation;
    UserDAO db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        validation = new Validation(this);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
//        tiEmail = findViewById(R.id.tiEmail);
//        tiPassword = findViewById(R.id.tiPassword);
        Button btnSubmit = findViewById(R.id.btnLogInPage);
        db = new UserDAO(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //crashing when the result match not displaying line error, if don't exist crash showing
                //line erro login.java:36 since returns as null from the table .
                boolean loginOK = db.checkLogin(etEmail.getText().toString(),etPassword.getText().toString());
                if(loginOK ){

                    Intent goPage2 = new Intent(Login.this, Page2.class);
                    startActivity(goPage2);
                }else{
                    Toast.makeText(Login.this,"Wrong Email or Password. ",Toast.LENGTH_LONG);
                }




            }
        });
    }
}
