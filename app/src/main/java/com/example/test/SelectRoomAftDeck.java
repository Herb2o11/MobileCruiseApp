package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRoomAftDeck extends AppCompatActivity {
    boolean selectRoom;
    String position = "Aft";
    String roomNumberSelected;
    String deckSelected = "Deck 1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room_aft_deck);

        final Button btnDeck1020 = findViewById(R.id.btnDeck1Aft1020);
        final Button btnDeck1022 = findViewById(R.id.btnDeck1Aft1022);
        final Button btnDeck1024 = findViewById(R.id.btnDeck1Aft1024);
        final Button btnDeck1026 = findViewById(R.id.btnDeck1Aft1026);

        final Button btnNext = findViewById(R.id.btnSubmitAftDeck1);







        btnDeck1020.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRoom = true;
                if(selectRoom = true){
                    btnDeck1020.setBackgroundColor(0xff0000ff);
                    btnDeck1022.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1024.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1026.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1020.getText().toString();
                }
            }
        });
        btnDeck1022.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRoom = true;
                if(selectRoom = true){
                    btnDeck1022.setBackgroundColor(0xff0000ff);
                    btnDeck1020.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1024.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1026.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1022.getText().toString();
                }
            }
        });
        btnDeck1024.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRoom = true;
                if(selectRoom = true){
                    btnDeck1024.setBackgroundColor(0xff0000ff);
                    btnDeck1020.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1022.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1026.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1024.getText().toString();
                }
            }
        });
        btnDeck1026.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRoom = true;
                if(selectRoom = true){
                    btnDeck1026.setBackgroundColor(0xff0000ff);
                    btnDeck1020.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1022.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1024.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1026.getText().toString();
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
