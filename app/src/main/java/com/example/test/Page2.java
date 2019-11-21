package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        final Button btnAccommodation = (Button) findViewById(R.id.buttonAccommodation);
        final Button btnDates=(Button)findViewById(R.id.buttonDates);
        final Button btnStateRoom = (Button)findViewById(R.id.btnStateRoom);

        final TextView txtDates = findViewById(R.id.txtDisplayMonth);
        final TextView txtDest = findViewById(R.id.txtDisplayDest);
        final TextView txtDepart = findViewById(R.id.txtDisplayDepart);


        Button btnDestination=(Button)findViewById(R.id.buttonDestinations);
        Button btnDepart=(Button)findViewById(R.id.buttonDepart);

        try {
            SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
            String showMonth = sharedPreferences.getString("month"," N/A ");
            String showDest = sharedPreferences.getString("dest"," N/A ");
            String showDepart = sharedPreferences.getString("depart","N/A");
            txtDates.setText(showMonth);
            txtDest.setText(showDest);
            txtDepart.setText(showDepart);

            //Intent intent = getIntent();
            //String displayMonth = intent.getExtras().getString("month", "");
            //txtDates.setText(displayMonth);

        }catch (Exception e){

        }


        btnAccommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAccommodation = new Intent(Page2.this, AccommodationPageActivity.class);
                startActivity(intentAccommodation);
            }
        });


        btnDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDestination=new Intent(Page2.this,Destination_Page.class);
                startActivity(intentDestination);
            }
        });


        btnDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDepart = new Intent(Page2.this, DeparturePageActivity.class);
                startActivity(intentDepart);
            }
        });


        btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDates = new Intent(Page2.this,DateSelection.class);
                startActivity(intentDates);
            }
        });

        btnStateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stateroomintent  = new Intent(Page2.this,StateRoomType.class);
                startActivity(stateroomintent);
            }
        });

    }
}
