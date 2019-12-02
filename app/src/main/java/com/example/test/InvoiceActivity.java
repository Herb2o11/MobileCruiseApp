package com.example.test;

import android.content.Context;
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
import android.widget.TextView;

import com.example.cruiseapp.PaymentDetailsActivity;

public class InvoiceActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        TextView txtPriceShowOfRoom=findViewById(R.id.txtShowPriceOfRoom);
        Button btnGoPay = findViewById(R.id.btnGoPayment);
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
            String showPrice = sharedPreferences.getString("price"," ");


            txtPriceShowOfRoom.setText(showPrice);








        }catch (Exception e){

        }

        btnGoPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(InvoiceActivity.this, PaymentDetailsActivity.class);
                startActivity(intent);
            }
        });

    }
}
