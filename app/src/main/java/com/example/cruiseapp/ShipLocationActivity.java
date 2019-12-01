package com.example.cruiseapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cruiseapp.db.CruiseDatabase;
import com.example.cruiseapp.db.entities.StateRoom;
import com.example.test.AdventurePackActivity;
import com.example.test.PageSelectionActivity;
import com.example.test.R;
import com.example.test.StateRoomTypeActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ShipLocationActivity extends AppCompatActivity {
    String stateType;
    String stateRoomPrice;
    String stateRoomCategory;
    String shipLoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_location2);

        //final RadioGroup radioSelectionType = findViewById(R.id.rdBtnGrpRoomCategory);
        LinearLayout linearLayout;
        List<StateRoom> stateRoomEntities = new ArrayList<>();
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        CruiseDatabase cruiseDatabase;

        cruiseDatabase = CruiseDatabase.getInstance(getApplicationContext());

        linearLayout = findViewById(R.id.room_type_container);

        Button btnForward=findViewById(R.id.btnForward);
        Button btnMidShip=findViewById(R.id.btnMidShip);
        Button btnAft=findViewById(R.id.btnAft);

        final RadioButton rbStandard=findViewById(R.id.radioButtonStandard);
        final RadioButton rbIntermediate=findViewById(R.id.radioButtonIntermediate);
        final RadioButton rbDelux=findViewById(R.id.radioButtonDelux);

        ScrollView svRooms=findViewById(R.id.scrollViewRooms);

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbStandard.isChecked()){

                }else if (rbIntermediate.isChecked()){

                }else if(rbDelux.isChecked()){

                }else{
                    Toast.makeText(ShipLocationActivity.this, "Please choose category of the room", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMidShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbStandard.isChecked()){

                }else if (rbIntermediate.isChecked()){

                }else if(rbDelux.isChecked()){

                }else{
                    Toast.makeText(ShipLocationActivity.this, "Please choose category of the room", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbStandard.isChecked()){

                }else if (rbIntermediate.isChecked()){

                }else if(rbDelux.isChecked()){

                }else{
                    Toast.makeText(ShipLocationActivity.this, "Please choose category of the room", Toast.LENGTH_SHORT).show();
                }
            }
        });

        LayoutInflater inflater = getLayoutInflater();



        stateRoomEntities = cruiseDatabase.stateRoomDao().getStateRooms();


        for (StateRoom stateRoom : stateRoomEntities) {
            View view = inflater.inflate(R.layout.state_room_row, linearLayout, false);




            ImageView imageView = view.findViewById(R.id.header_image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //inserting the selection of stateroom type
                    try {
                        RadioGroup radioSelectionType = findViewById(R.id.rdBtnGrpRoomCategory);
                        //for the radiogroup
                        int selectedRadioButtonType = radioSelectionType.getCheckedRadioButtonId();
                        // If nothing is selected from Radio Group, then it return -1
                        if (selectedRadioButtonType != -1) {


                            RadioButton selectedRadioButton = findViewById(selectedRadioButtonType);
                            stateType = selectedRadioButton.getText().toString();
                            SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("State",stateType);
                            editor.apply();

                            Intent intentAdventure = new Intent(ShipLocationActivity.this, PageSelectionActivity.class);

                            startActivity(intentAdventure);


                        } else{
                            Toast.makeText(ShipLocationActivity.this, "Select one category", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e) {
                    }





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
