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

    UserDAO db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etEmail = findViewById(R.id.etLoginConfirm);
        final EditText etPassword = findViewById(R.id.etPasswordLogIn);
        Button btnGoToRegisterFromLogInPage=(Button)findViewById(R.id.btnSignUpLogPage);
        Button btnSubmit = findViewById(R.id.btnLogInPage);

        db = new UserDAO(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // not doing the checking
                boolean loginOK = db.checkLogin(etEmail.getText().toString(),etPassword.getText().toString());
                if(loginOK){
                    Intent goPage2 = new Intent(Login.this, Page2.class);
                    startActivity(goPage2);
                    finish();
                }else if(etEmail.length()==0 || etPassword.length()==0){
                    Toast.makeText(Login.this, "Please Enter Email, and Password",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Login.this,"Wrong Email or Password. ",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnGoToRegisterFromLogInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goRegisterPage=new Intent(Login.this, Register.class);
                startActivity(goRegisterPage);
                finish();
            }
        });
    }
}
