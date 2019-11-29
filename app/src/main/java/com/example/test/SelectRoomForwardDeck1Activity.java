package com.example.test;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRoomForwardDeck1Activity extends AppCompatActivity {
    boolean selectRoom;
    String  position ="Forward";
    String deckSelected = "Deck 1";
    String roomNumberSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room_forward_deck1);

        final Button btnDeck1000  = findViewById(R.id.btnDeck1Forward1000);
        final Button btnDeck1002  = findViewById(R.id.btnDeck1Forward1002);
        final Button btnDeck1004  = findViewById(R.id.btnDeck1Forward1004);
        final Button btnDeck1006  = findViewById(R.id.btnDeck1Forward1006);
        final Button btnDeck1008  = findViewById(R.id.btnDeck1Forward1008);

        final Button btnNext = findViewById(R.id.btnSubmitForwardDeck1);



        btnDeck1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1000.setBackgroundColor(0xff0000ff);
                    btnDeck1002.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1004.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1006.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1008.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1000.getText().toString();
                }
            }
        });

        btnDeck1002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1002.setBackgroundColor(0xff0000ff);
                    btnDeck1000.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1004.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1006.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1008.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1002.getText().toString();

                }
            }
        });

        btnDeck1004.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1004.setBackgroundColor(0xff0000ff);
                    btnDeck1000.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1002.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1006.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1008.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1004.getText().toString();
                }
            }
        });

        btnDeck1006.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1006.setBackgroundColor(0xff0000ff);
                    btnDeck1000.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1002.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1004.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1008.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1006.getText().toString();
                }
            }
        });

        btnDeck1008.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck1008.setBackgroundColor(0xff0000ff);
                    btnDeck1000.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1002.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1004.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck1006.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck1008.getText().toString();

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
