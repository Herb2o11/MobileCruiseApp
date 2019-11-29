package com.example.test;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRoomForwardDeck1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room_forward_deck1);

        final Button btnDeck1000  = findViewById(R.id.btnDeck1Forward1000);



        btnDeck1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDeck1000.setBackgroundColor(0xff0000ff);

                //default button color
                //btn.setBackgroundResource(android.R.drawable.btn_default);
            }
        });


    }
}
