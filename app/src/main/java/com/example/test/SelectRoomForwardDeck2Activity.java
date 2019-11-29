package com.example.test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRoomForwardDeck2Activity extends AppCompatActivity {
    boolean selectRoom;
    String  position ="Forward";
    String roomNumberSelected;
    String deckSelected = "Deck 2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room_forward_deck2);

        final Button btnDeck2000  = findViewById(R.id.btnDeck1Forward2000);
        final Button btnDeck2002  = findViewById(R.id.btnDeck1Forward2002);
        final Button btnDeck2004  = findViewById(R.id.btnDeck1Forward2004);
        final Button btnDeck2006  = findViewById(R.id.btnDeck1Forward2006);
        final Button btnDeck2008  = findViewById(R.id.btnDeck1Forward2008);

        final Button btnNext = findViewById(R.id.btnSubmitForwardDeck2);



        btnDeck2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2000.setBackgroundColor(0xff0000ff);
                    btnDeck2002.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2004.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2006.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2008.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2000.getText().toString();
                }
            }
        });

        btnDeck2002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2002.setBackgroundColor(0xff0000ff);
                    btnDeck2000.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2004.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2006.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2008.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2002.getText().toString();

                }
            }
        });

        btnDeck2004.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2004.setBackgroundColor(0xff0000ff);
                    btnDeck2000.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2002.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2006.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2008.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2004.getText().toString();
                }
            }
        });

        btnDeck2006.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2006.setBackgroundColor(0xff0000ff);
                    btnDeck2000.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2002.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2004.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2008.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2006.getText().toString();
                }
            }
        });

        btnDeck2008.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2008.setBackgroundColor(0xff0000ff);
                    btnDeck2000.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2002.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2004.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2006.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2008.getText().toString();

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
