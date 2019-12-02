package com.example.cruiseapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test.ExistingUserActivity;
import com.example.test.PageSelectionActivity;
import com.example.test.R;

public class PaymentDetailsActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.redirection_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.go_to_Create:
                Intent intentTOPageSelection=new Intent(getApplicationContext(), PageSelectionActivity.class);
                startActivity(intentTOPageSelection);
                return true;

            case R.id.go_to_Existing:
                Intent intentToExisting=new Intent(getApplicationContext(), ExistingUserActivity.class);
                startActivity(intentToExisting);
                return true;

            default:
                super.onOptionsItemSelected(item);
        }
        if(item.getItemId()==R.id.go_to_Existing){
            Intent intent=new Intent(getApplicationContext(), ExistingUserActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    String eMonth, eYear, eAmount, eCVV, eCardN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);


        final TextView txtAmtFinal = findViewById(R.id.txtAmtDisplay);
        final EditText etxtCardNumber = findViewById(R.id.etxtCardN);
        final EditText etxtExpDateYear = findViewById(R.id.etxtExpDateYear);
        final EditText etxtExpDateMonth = findViewById(R.id.etxtExpDateMonth);
        final EditText etxtCVV = findViewById(R.id.etxtCVV);
        final Button btnPay = findViewById(R.id.btnPayConfirmation);


        eCardN = etxtCardNumber.getText().toString();
        eMonth = etxtExpDateMonth.getText().toString();
        eYear = etxtExpDateYear.getText().toString();
        eCVV = etxtCVV.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("dataShared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("cardNumber",eCardN);
        editor.putString("expireDateMonth",eMonth);
        editor.putString("expireDateYear",eYear);
        //editor.putString("CVV",eCVV);

        editor.commit();

        //Getting the total amount from the sharedpreferences


        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //#######Insert the the name of the profile Page####

                //Intent intent = new Intent(PaymentDetailsActivity.this,ProfilePage.class);
                Intent intentToExistingUserPage=new Intent(PaymentDetailsActivity.this, ExistingUserActivity.class);
                startActivity(intentToExistingUserPage);
                finish();



            }
        });



    }
}
