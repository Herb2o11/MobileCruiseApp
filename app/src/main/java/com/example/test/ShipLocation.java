package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShipLocation extends AppCompatActivity {
    Button btnAft, btnMid, btnForward, btnDeck1Aft, btnDeck2Aft, btnDeck3Aft, btnDeck1Mid, btnDeck2Mid, btnDeck3Mid,
            btnDeck1Forward, btnDeck2Forward, btnDeck3Forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_location);
        //to connect buttons
        btnAft=findViewById(R.id.btnAft);
        btnMid=findViewById(R.id.btnMidShip);
        btnForward=findViewById(R.id.btnForward);

        //Deck buttons
        btnDeck1Aft=findViewById(R.id.btnDeck1Aft);
        btnDeck2Aft=findViewById(R.id.btnDeck2Aft);
        btnDeck3Aft=findViewById(R.id.btnDeck3Aft);

        btnDeck1Mid=findViewById(R.id.btnDeck1Mid);
        btnDeck2Mid=findViewById(R.id.btnDeck2Mid);
        btnDeck3Mid=findViewById(R.id.btnDeck3Mid);

        btnDeck1Forward=findViewById(R.id.btnDeck1Forward);
        btnDeck2Forward=findViewById(R.id.btnDeck2Forward);
        btnDeck3Forward=findViewById(R.id.btnDeck3Forward);

        btnAft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDeck1Aft.setVisibility(View.VISIBLE);
                btnDeck2Aft.setVisibility(View.VISIBLE);
                btnDeck3Aft.setVisibility(View.VISIBLE);

                btnDeck1Mid.setVisibility(View.INVISIBLE);
                btnDeck2Mid.setVisibility(View.INVISIBLE);
                btnDeck3Mid.setVisibility(View.INVISIBLE);

                btnDeck1Forward.setVisibility(View.INVISIBLE);
                btnDeck2Forward.setVisibility(View.INVISIBLE);
                btnDeck3Forward.setVisibility(View.INVISIBLE);
            }
        });

        btnMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDeck1Mid.setVisibility(View.VISIBLE);
                btnDeck2Mid.setVisibility(View.VISIBLE);
                btnDeck3Mid.setVisibility(View.VISIBLE);

                btnDeck1Aft.setVisibility(View.INVISIBLE);
                btnDeck2Aft.setVisibility(View.INVISIBLE);
                btnDeck3Aft.setVisibility(View.INVISIBLE);

                btnDeck1Forward.setVisibility(View.INVISIBLE);
                btnDeck2Forward.setVisibility(View.INVISIBLE);
                btnDeck3Forward.setVisibility(View.INVISIBLE);
            }
        });

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDeck1Forward.setVisibility(View.VISIBLE);
                btnDeck2Forward.setVisibility(View.VISIBLE);
                btnDeck3Forward.setVisibility(View.VISIBLE);

                btnDeck1Aft.setVisibility(View.INVISIBLE);
                btnDeck2Aft.setVisibility(View.INVISIBLE);
                btnDeck3Aft.setVisibility(View.INVISIBLE);

                btnDeck1Mid.setVisibility(View.INVISIBLE);
                btnDeck2Mid.setVisibility(View.INVISIBLE);
                btnDeck3Mid.setVisibility(View.INVISIBLE);

            }
        });
    }

}
