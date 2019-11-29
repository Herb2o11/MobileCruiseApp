package com.example.test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRoomMidShipDeck1Activity extends AppCompatActivity {
    boolean selectRoom;
    String position = "MidShip";
    String deckSelected = "Deck 1";
    String roomNumberSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room_mid_ship_deck1);

        final Button btnDeck1010  = findViewById(R.id.btnDeck1MidShip1010);
        final Button btnDeck1012  = findViewById(R.id.btnDeck1MidShip1012);
        final Button btnDeck1014  = findViewById(R.id.btnDeck1MidShip1014);
        final Button btnDeck1016  = findViewById(R.id.btnDeck1MidShip1016);

        final Button btnNext = findViewById(R.id.btnSubmitMidShipDeck1);


        btnDeck1010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1010.setBackgroundColor(0xff0000ff);
                    btnDeck1012.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1014.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1016.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1010.getText().toString();
                }
            }
        });
        btnDeck1012.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1012.setBackgroundColor(0xff0000ff);
                    btnDeck1010.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1014.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1016.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1012.getText().toString();
                }
            }
        });
        btnDeck1014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1014.setBackgroundColor(0xff0000ff);
                    btnDeck1010.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1012.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1016.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1014.getText().toString();
                }
            }
        });
        btnDeck1016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1016.setBackgroundColor(0xff0000ff);
                    btnDeck1010.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1012.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1014.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1016.getText().toString();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("selectedPart",position);
                editor.putString("selectedRoom",roomNumberSelected);
                editor.putString("deckChosen",deckSelected);

                // Intent intent = new Intent(SelectRoomAftDeck.this,Invoice.class)
            }
        });










    }
}
