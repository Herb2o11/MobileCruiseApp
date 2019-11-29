package com.example.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StateRoomTypeActivity extends AppCompatActivity {

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

    LinearLayout linearLayout;
    List<StateRoomEntity> stateRoomEntities = new ArrayList<>();
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_room_type2);

        linearLayout = findViewById(R.id.state_room_container);
        LayoutInflater inflater = getLayoutInflater();

        stateRoomEntities = Arrays.asList(
                new StateRoomEntity(R.drawable.insidestateroom, "Inside State Room", "These are our most spacious non-Concierge staterooms, each with a private verandah (some with partial views).", 2769.43),
                new StateRoomEntity(R.drawable.oceanviewstateroom, "Ocean View State Room", "Unwind in roomy quarters adorned in a charming nautical motif, with a real porthole window—or possibly 2!", 3500.0),
                new StateRoomEntity(R.drawable.conciergestateroom, "Concierge State Room", "Sail away in a generous-sized stateroom with a nautical motif and porthole mirror (no exterior view).", 1543.43)
        );

        for (StateRoomEntity stateRoomEntity : stateRoomEntities) {
            View view = inflater.inflate(R.layout.state_room_row, linearLayout, false);

            ImageView imageView = view.findViewById(R.id.header_image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  Toast.makeText(StateRoomTypeActivity.this, "testImageclick", Toast.LENGTH_SHORT).show();
                    Intent intentAdventure = new Intent(StateRoomTypeActivity.this,AdventurePackActivity.class);
                    startActivity(intentAdventure);


                }
            });
            TextView txtName = view.findViewById(R.id.txt_room_info);
            TextView txtDeck = view.findViewById(R.id.txt_stateroominfo);
            TextView txtPrice = view.findViewById(R.id.txt_price);

            imageView.setImageDrawable(getResources().getDrawable(stateRoomEntity.getImage()));
            txtName.setText(stateRoomEntity.getName());
            txtDeck.setText(stateRoomEntity.getDescription());
            txtPrice.setText(numberFormat.format(stateRoomEntity.getPrice()));

            linearLayout.addView(view);
        }

    }





        }
