package com.example.cruiseapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.StateRoomTypeActivity;

public class ConfirmSelectionActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_selection);

        final TextView txtConfirmMonth = findViewById(R.id.txtConMonth);
        final TextView txtConfirmDest = findViewById(R.id.txtConDest);
        final TextView txtConfirmDepart = findViewById(R.id.txtConDepart);
        final TextView txtConfirmday = findViewById(R.id.txtConDay);
        final TextView txtConfirmAcc = findViewById(R.id.txtNumberSrateRoom);
        final TextView txtConfirmAdults = findViewById(R.id.txtNumberAdults);
        final TextView txtConfirmKids = findViewById(R.id.txtNumberKids);


 //        getSupportActionBar().setTitle("Shecdule your travel");
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.icon_disneycastleb_round);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);


        try {
            SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
            String showMonth = sharedPreferences.getString("month"," N/A ");
            String showDest = sharedPreferences.getString("dest"," N/A ");
            String showDepart = sharedPreferences.getString("depart","N/A");
            String showDay = sharedPreferences.getString("daySelected","N/A");
            String showstate = sharedPreferences.getString("accNumber"," N/A ");
            String showadults = sharedPreferences.getString("adults","N/A");
            String showKids = sharedPreferences.getString("kids","N/A");


            txtConfirmMonth.setText(showMonth);
            txtConfirmDest.setText(showDest);
            txtConfirmDepart.setText(showDepart);
            txtConfirmday.setText(showDay);
            txtConfirmAcc.setText(showstate);
            txtConfirmAdults.setText(showadults);
            txtConfirmKids.setText(showKids);




        }catch (Exception e){

        }




        final Button btnConfirm = (Button) findViewById(R.id.btnConfirmGoState);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmSelectionActivity.this, StateRoomTypeActivity.class);
                startActivity(intent);

            }
        }
        );


    }
}
