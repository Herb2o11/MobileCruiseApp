package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        final Button btnAccommodation = (Button) findViewById(R.id.buttonAccommodation);
        Button btnDates=(Button)findViewById(R.id.buttonDates);
        Button btnDestination=(Button)findViewById(R.id.buttonDestinations);
        Button btnDepart=(Button)findViewById(R.id.buttonDepart);

        btnAccommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAccommodation = new Intent(Page2.this, AccommodationPage.class);
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

        btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDates = new Intent(Page2.this,DateSelection.class);
                startActivity(intentDates);
            }
        });



    }
}
