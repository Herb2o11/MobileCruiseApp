package com.example.cruiseapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.example.test.ExistingUserActivity;
import com.example.test.PageSelectionActivity;
import com.example.test.R;
import com.example.test.StateRoomTypeActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;




public class ShipLocationActivity extends AppCompatActivity {

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
    String stateType;
    String shipLoc;
    String price;

    CruiseDatabase cruiseDatabase;


    LinearLayout linearLayout;
    List<StateRoom> stateRoomEntities = new ArrayList<>();
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_location2);

        //final RadioGroup radioSelectionType = findViewById(R.id.rdBtnGrpRoomCategory);


        cruiseDatabase = CruiseDatabase.getInstance(getApplicationContext());

        linearLayout = findViewById(R.id.room_type_container);

        final TextView txt_price=findViewById(R.id.txt_price);
        final LayoutInflater inflater = getLayoutInflater();

        final Button btnForward = findViewById(R.id.btnForward);
        final Button btnMidShip = findViewById(R.id.btnMidShip);
        final Button btnAft = findViewById(R.id.btnAft);

        final RadioButton rbStandard = findViewById(R.id.radioButtonStandard);
        final RadioButton rbIntermediate = findViewById(R.id.radioButtonIntermediate);
        final RadioButton rbDelux = findViewById(R.id.radioButtonDelux);

        ScrollView svRooms = findViewById(R.id.scrollViewRooms);

        btnForward.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                //Change button background
                btnAft.setBackground(getResources().getDrawable(R.drawable.aft_custom_button));
                btnForward.setBackground(getResources().getDrawable(R.drawable.forwardselected));
                btnMidShip.setBackground(getResources().getDrawable(R.drawable.midship_custom_btn));


                shipLoc = "Forward";
                final SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
                final SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("locationInShip",shipLoc);
                editor.apply();


                //clear list
                stateRoomEntities.clear();
                //Clear layout
                linearLayout.removeAllViews();

                stateRoomEntities = cruiseDatabase.stateRoomDao().getFowardStateRoom();

                for (StateRoom stateRoom : stateRoomEntities) {
                    View view = inflater.inflate(R.layout.state_room_row, linearLayout, false);

                    ImageView imageView = view.findViewById(R.id.header_image);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intentAdventure = new Intent(ShipLocationActivity.this, PageSelectionActivity.class);
                            startActivity(intentAdventure);
                            txt_price.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    price=txt_price.getText().toString();
                                    SharedPreferences sharedPreferences=getSharedPreferences("dataShared", MODE_PRIVATE);
                                    SharedPreferences.Editor editor1=sharedPreferences.edit();
                                    editor.putString("price", price);
                                    editor.apply();
                                }
                            });

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


        });


        btnMidShip.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {


                //Change button background
                btnAft.setBackground(getResources().getDrawable(R.drawable.aft_custom_button));
                btnForward.setBackground(getResources().getDrawable(R.drawable.forward_custom_btn));
                btnMidShip.setBackground(getResources().getDrawable(R.drawable.midshipselected));


                shipLoc = "Midship";
                SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("locationInShip",shipLoc);
                editor.apply();

                if (rbStandard.isChecked()) {

                } else if (rbIntermediate.isChecked()) {

                } else if (rbDelux.isChecked()) {

                } else {
                    Toast.makeText(ShipLocationActivity.this, "Please choose category of the room", Toast.LENGTH_SHORT).show();
                }

                //clear list
                stateRoomEntities.clear();
                //Clear layout
                linearLayout.removeAllViews();


                stateRoomEntities = cruiseDatabase.stateRoomDao().getMidStateRoom();
                for (StateRoom stateRoom : stateRoomEntities) {
                    View view = inflater.inflate(R.layout.state_room_row, linearLayout, false);

                    ImageView imageView = view.findViewById(R.id.header_image);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intentAdventure = new Intent(ShipLocationActivity.this, PageSelectionActivity.class);
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
        });

        btnAft.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {


                //Change button background
                btnAft.setBackground(getResources().getDrawable(R.drawable.aftselected));
                btnForward.setBackground(getResources().getDrawable(R.drawable.forward_custom_btn));
                btnMidShip.setBackground(getResources().getDrawable(R.drawable.midship_custom_btn));


                shipLoc = " Aft ";
                SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("locationInShip",shipLoc);
                editor.apply();

                if (rbStandard.isChecked()) {

                } else if (rbIntermediate.isChecked()) {

                } else if (rbDelux.isChecked()) {

                } else {
                    Toast.makeText(ShipLocationActivity.this, "Please choose category of the room", Toast.LENGTH_SHORT).show();
                }

                //clear list
                stateRoomEntities.clear();
                //Clear layout
                linearLayout.removeAllViews();

                stateRoomEntities = cruiseDatabase.stateRoomDao().getAftStateRoom();

                for (StateRoom stateRoom : stateRoomEntities) {
                    View view = inflater.inflate(R.layout.state_room_row, linearLayout, false);

                    ImageView imageView = view.findViewById(R.id.header_image);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intentAdventure = new Intent(ShipLocationActivity.this, PageSelectionActivity.class);
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
        });

        rbStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateType = rbStandard.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("stateType",stateType);
                editor.apply();
            }
        });

        rbIntermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateType = rbIntermediate.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("stateType",stateType);
                editor.apply();
            }
        });

        rbDelux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateType = rbDelux.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("stateType",stateType);
                editor.apply();
            }
        });
        stateRoomEntities = cruiseDatabase.stateRoomDao().getStateRooms();


    }
}