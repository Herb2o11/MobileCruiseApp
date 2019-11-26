package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cruiseapp.AccommodationSelectionActivity;
import com.example.cruiseapp.ConfirmSelectionActivity;

public class PageSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageselection);

//        getSupportActionBar().setTitle("Shecdule your travel");
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.icon_disneycastleb_round);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final Button btnAccommodation =  findViewById(R.id.buttonAccommodation);
        final Button btnDates=findViewById(R.id.buttonDates);
        final Button btnStateRoom = findViewById(R.id.btnStateRoom);
        Button btnFindPrice=findViewById(R.id.btnFindPrice);
        final Button btngoConfirm= findViewById(R.id.btnGoToConfimationPage);

        final TextView txtDates = findViewById(R.id.txtDisplayMonth);
        final TextView txtDest = findViewById(R.id.txtDisplayDest);
        final TextView txtDepart = findViewById(R.id.txtDisplayDepart);
        final TextView txtday = findViewById(R.id.txtDisplayDay);


        Button btnDestination=(Button)findViewById(R.id.buttonDestinations);
        Button btnDepart=(Button)findViewById(R.id.buttonDepart);

        try {
            SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
            String showMonth = sharedPreferences.getString("month"," N/A ");
            String showDest = sharedPreferences.getString("dest"," N/A ");
            String showDepart = sharedPreferences.getString("depart","N/A");
            String showDay = sharedPreferences.getString("daySelected","N/A");
            txtDates.setText(showMonth);
            txtDest.setText(showDest);
            txtDepart.setText(showDepart);
            txtday.setText(showDay);

        }catch (Exception e){

        }


        btnAccommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAccommodation = new Intent(PageSelectionActivity.this, AccommodationSelectionActivity.class);
                startActivity(intentAccommodation);
            }
        });


        btnDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDestination=new Intent(PageSelectionActivity.this, DestinationPageActivity.class);
                startActivity(intentDestination);
            }
        });


        btnDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDepart = new Intent(PageSelectionActivity.this, DeparturePageActivity.class);
                startActivity(intentDepart);
            }
        });


        btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDates = new Intent(PageSelectionActivity.this, DateSelectionActivity.class);
                startActivity(intentDates);
            }
        });

        btnStateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stateroomintent  = new Intent(PageSelectionActivity.this, StateRoomTypeActivity.class);
                startActivity(stateroomintent);
            }
        });

        btnFindPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shipLocationIntent= new Intent (PageSelectionActivity.this, ShipLocationActivity.class);
                startActivity(shipLocationIntent);

            }
        });

        btngoConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmSelectionAct= new Intent (PageSelectionActivity.this, ConfirmSelectionActivity.class);
                startActivity(confirmSelectionAct);
            }
        });


    }
}
