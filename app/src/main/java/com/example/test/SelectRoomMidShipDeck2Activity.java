package com.example.test;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class SelectRoomMidShipDeck2Activity extends AppCompatActivity {
    boolean selectRoom;
    String position = "MidShip";
    String roomNumberSelected;
    String deckSelected = "Deck 2";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.redirection_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.go_to_Create:
                Intent intentTOPageSelection=new Intent(getApplicationContext(), PageSelectionActivity.class);
                startActivity(intentTOPageSelection);
                return true;

            case R.id.go_to_Existing:
                Intent intentToExisting=new Intent(getApplicationContext(), ExistingUserActivity.class);
                startActivity(intentToExisting);
                return true;

            default:
                super.onOptionsItemSelected(item);
        }
        if(item.getItemId()==R.id.go_to_Existing){
            Intent intent=new Intent(getApplicationContext(), ExistingUserActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room_mid_ship_deck2);

        final Button btnDeck2010  = findViewById(R.id.btnDeck1MidShip2010);
        final Button btnDeck2012  = findViewById(R.id.btnDeck1MidShip2012);
        final Button btnDeck2014  = findViewById(R.id.btnDeck1MidShip2014);
        final Button btnDeck2016  = findViewById(R.id.btnDeck1MidShip2016);

        final Button btnNext = findViewById(R.id.btnSubmitMidShipDeck2);


        btnDeck2010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2010.setBackgroundColor(0xff0000ff);
                    btnDeck2012.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2014.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2016.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2010.getText().toString();
                }
            }
        });
        btnDeck2012.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2012.setBackgroundColor(0xff0000ff);
                    btnDeck2010.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2014.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2016.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2012.getText().toString();
                }
            }
        });
        btnDeck2014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2014.setBackgroundColor(0xff0000ff);
                    btnDeck2010.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2012.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2016.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2014.getText().toString();
                }
            }
        });
        btnDeck2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRoom = true;
                if(selectRoom = true) {
                    btnDeck2016.setBackgroundColor(0xff0000ff);
                    btnDeck2010.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2012.setBackgroundResource(android.R.drawable.btn_default);
                    btnDeck2014.setBackgroundResource(android.R.drawable.btn_default);
                    roomNumberSelected = btnDeck2016.getText().toString();
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
