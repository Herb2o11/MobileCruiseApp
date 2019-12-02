package com.example.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cruiseapp.ConfirmSelectionActivity;
import com.example.cruiseapp.db.CruiseDatabase;
import com.example.cruiseapp.db.entities.User;

public class PageSelectionActivity extends AppCompatActivity {

    CruiseDatabase cruiseDatabase;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.redirection_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

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
        setContentView(R.layout.activity_pageselection);

        cruiseDatabase = CruiseDatabase.getInstance(getApplicationContext());

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        long id = sharedPref.getLong("ID", 0);

        User user = cruiseDatabase.userDao().getUser(id);
        Log.d("USER", user.getEmail());

        final Button btnStateRoom =  findViewById(R.id.btnStateRoom);
        final Button btnDates=findViewById(R.id.buttonDates);
        Button btnFindPrice=findViewById(R.id.btnFindPrice);
        final Button btngoConfirm= findViewById(R.id.btnGoToConfimationPage);

        final TextView txtDates = findViewById(R.id.txtDisplayMonth);
        final TextView txtDest = findViewById(R.id.txtDisplayDest);
        final TextView txtDepart = findViewById(R.id.txtDisplayDepart);
        final TextView txtday = findViewById(R.id.txtDisplayDay);



        Button btnDestination=(Button)findViewById(R.id.buttonDestinations);
        Button btnDepart=(Button)findViewById(R.id.buttonDepart);


        try {
            SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
            String showMonth = sharedPreferences.getString("month"," N/A ");
            String showDest = sharedPreferences.getString("dest"," N/A ");
            String showDepart = sharedPreferences.getString("depart","N/A");
            String showDay = sharedPreferences.getString("daySelected","N/A");
            txtDates.setText(showMonth);
            txtDest.setText(showDest);
            txtDepart.setText(showDepart);
            txtday.setText(showDay);

        }catch (Exception e){

        }


        btnStateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //using the new type of selection for test
                Intent intentAccommodation = new Intent(PageSelectionActivity.this, com.example.cruiseapp.ShipLocationActivity.class);
                startActivity(intentAccommodation);
            }
        });


        btnDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDestination=new Intent(PageSelectionActivity.this, DestinationPageActivity.class);
                startActivity(intentDestination);
            }
        });


        btnDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDepart = new Intent(PageSelectionActivity.this, DeparturePageActivity.class);
                startActivity(intentDepart);
            }
        });


        btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDates = new Intent(PageSelectionActivity.this, DateSelectionActivity.class);
                startActivity(intentDates);
            }
        });


        btnFindPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shipLocationIntent= new Intent (PageSelectionActivity.this, ShipLocationActivity.class);
                startActivity(shipLocationIntent);

            }
        });

        btngoConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmSelectionAct= new Intent (PageSelectionActivity.this, ConfirmSelectionActivity.class);
                startActivity(confirmSelectionAct);
            }
        });


    }
}
