package com.example.test;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        getSupportActionBar().setTitle("Home");
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.icon_disneycastleb_round);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnRegister=(Button)findViewById(R.id.btnSignUp);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                Intent iLogin=new Intent(this, Login.class);
                startActivity(iLogin);
                break;
            case R.id.btnSignUp:
                Intent iRegister= new Intent(this, Register.class);
                startActivity(iRegister);
                break;
                default:
                    break;
        }
    }
}
