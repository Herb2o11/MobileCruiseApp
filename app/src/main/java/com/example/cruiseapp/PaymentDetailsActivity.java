package com.example.cruiseapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test.R;

public class PaymentDetailsActivity extends AppCompatActivity {
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



    }
}
