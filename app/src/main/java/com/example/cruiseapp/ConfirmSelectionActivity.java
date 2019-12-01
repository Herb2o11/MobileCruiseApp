package com.example.cruiseapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.ExistingUserActivity;
import com.example.test.PageSelectionActivity;
import com.example.test.R;
import com.example.test.StateRoomTypeActivity;

public class ConfirmSelectionActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_confirm_selection);

        final TextView txtConfirmMonth = findViewById(R.id.txtConMonth);
        final TextView txtConfirmDest = findViewById(R.id.txtConDest);
        final TextView txtConfirmDepart = findViewById(R.id.txtConDepart);
        final TextView txtConfirmday = findViewById(R.id.txtConDay);
        final TextView txtConfirmAcc = findViewById(R.id.txtNumberSrateRoom);
        final TextView txtConfirmAdults = findViewById(R.id.txtNumberAdults);
        final TextView txtConfirmKids = findViewById(R.id.txtNumberKids);


 //        getSupportActionBar().setTitle("Schedule your travel");
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.icon_disneycastleb_round);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);


        try {
            SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
            String showMonth = sharedPreferences.getString("month"," N/A ");
            String showDest = sharedPreferences.getString("dest"," N/A ");
            String showDepart = sharedPreferences.getString("depart","N/A");
            String showDay = sharedPreferences.getString("daySelected","N/A");
            String showstate = sharedPreferences.getString("selectedPart"," N/A ");
            String showadults = sharedPreferences.getString("selectedRoom","N/A");
            String showStateType = sharedPreferences.getString("State","N");


            txtConfirmMonth.setText(showMonth);
            txtConfirmDest.setText(showDest);
            txtConfirmDepart.setText(showDepart);
            txtConfirmday.setText(showDay);
            txtConfirmAcc.setText(showstate);
            txtConfirmAdults.setText(showadults);
            txtConfirmKids.setText(showStateType);




        }catch (Exception e){

        }




        final Button btnConfirm = (Button) findViewById(R.id.btnConfirmGoState);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmSelectionActivity.this, StateRoomTypeActivity.class);
                startActivity(intent);

            }
        }
        );


    }
}
