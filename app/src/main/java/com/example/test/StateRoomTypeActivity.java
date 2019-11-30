package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cruiseapp.db.CruiseDatabase;
import com.example.cruiseapp.db.entities.StateRoom;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StateRoomTypeActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    List<StateRoom> stateRoomEntities = new ArrayList<>();
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    CruiseDatabase cruiseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_room_type2);

        cruiseDatabase = CruiseDatabase.getInstance(getApplicationContext());

        linearLayout = findViewById(R.id.state_room_container);
        LayoutInflater inflater = getLayoutInflater();

        stateRoomEntities = cruiseDatabase.stateRoomDao().getStateRooms();

        for (StateRoom stateRoom : stateRoomEntities) {
            View view = inflater.inflate(R.layout.state_room_row, linearLayout, false);

            ImageView imageView = view.findViewById(R.id.header_image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentAdventure = new Intent(StateRoomTypeActivity.this,AdventurePackActivity.class);
                    startActivity(intentAdventure);

                }
            });
            TextView txtName = view.findViewById(R.id.txt_room_info);
            TextView txtDeck = view.findViewById(R.id.txt_stateroominfo);
            TextView txtPrice = view.findViewById(R.id.txt_price);

            imageView.setImageResource(getResources().getIdentifier(stateRoom.getPicId(), "drawable", getPackageName()));
            txtName.setText(stateRoom.getRoomCategory());
            txtDeck.setText(stateRoom.getRoomLocation());
            txtPrice.setText(numberFormat.format(stateRoom.getRoomPrice()));

            linearLayout.addView(view);
        }

    }





        }
