package com.example.test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRoomAftDeck2 extends AppCompatActivity {
    boolean selectRoom;
    String position = "Aft";
    String roomNumberSelected;
    String deckSelected = "Deck 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room_aft_deck2);


        final Button btnDeck2020 = findViewById(R.id.btnDeck2Aft2020);
        final Button btnDeck2022 = findViewById(R.id.btnDeck2Aft2022);
        final Button btnDeck2024 = findViewById(R.id.btnDeck2Aft2024);
        final Button btnDeck2026 = findViewById(R.id.btnDeck2Aft2026);

        final Button btnNext = findViewById(R.id.btnSubmitAftDeck2);

        btnDeck2020.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRoom = true;
                if(selectRoom = true){
                    btnDeck2020.setBackgroundColor(0xff0000ff);
                    btnDeck2022.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2024.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2026.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2020.getText().toString();
                }
            }
        });
        btnDeck2022.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRoom = true;
                if(selectRoom = true){
                    btnDeck2022.setBackgroundColor(0xff0000ff);
                    btnDeck2020.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2024.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2026.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2022.getText().toString();
                }
            }
        });
        btnDeck2024.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRoom = true;
                if(selectRoom = true){
                    btnDeck2024.setBackgroundColor(0xff0000ff);
                    btnDeck2020.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2022.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2026.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2024.getText().toString();
                }
            }
        });
        btnDeck2026.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRoom = true;
                if(selectRoom = true){
                    btnDeck2026.setBackgroundColor(0xff0000ff);
                    btnDeck2020.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2022.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2024.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2026.getText().toString();
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
