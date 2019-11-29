package com.example.test;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AccommodationPageActivity extends AppCompatActivity {

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


    int i = 1;
    int adults, children;
    String test1, test2;
    String excess = "If you would like to book more than 3 staterooms for the same cruise, please make multiple reservations.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation_page);

        final TableLayout tblLayout = (TableLayout) findViewById(R.id.tableLayout);
        Button btn = (Button) findViewById(R.id.button9);
        Button btn1 = (Button) findViewById(R.id.button10);

        final ArrayList<String> spinnerAdults = new ArrayList<String>();
        spinnerAdults.add("1");
        spinnerAdults.add("2");
        spinnerAdults.add("3");
        spinnerAdults.add("4");

        final ArrayAdapter<String> spinnerAdultsAdapter = new ArrayAdapter<String>(AccommodationPageActivity.this, android.R.layout.simple_spinner_dropdown_item, spinnerAdults);

        ArrayList<String> spinnerChildren = new ArrayList<String>();
        spinnerChildren.add("0");
        spinnerChildren.add("1");
        spinnerChildren.add("2");
        spinnerChildren.add("3");
        spinnerChildren.add("4");

        final ArrayAdapter<String> spinnerChildrenAdapter = new ArrayAdapter<String>(AccommodationPageActivity.this, android.R.layout.simple_spinner_dropdown_item, spinnerChildren);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i <= 3) {
                    TableRow newSR = new TableRow(AccommodationPageActivity.this);
                    TextView txtSR = new TextView(AccommodationPageActivity.this);
                    TextView txtSR1 = new TextView(AccommodationPageActivity.this);
                    TextView txtSR2 = new TextView(AccommodationPageActivity.this);
                    Spinner spin1 = new Spinner(AccommodationPageActivity.this);
                    Spinner spin2 = new Spinner(AccommodationPageActivity.this);
                    Button btnD = new Button(AccommodationPageActivity.this);
                    txtSR.setText(String.format("Stateroom %1d:", i));
                    txtSR1.setText("\tAdults: ");
                    spin1.setAdapter(spinnerAdultsAdapter);
                    txtSR2.setText("\tChildren: ");
                    spin2.setAdapter(spinnerChildrenAdapter);
                    newSR.addView(txtSR);
                    newSR.addView(txtSR1);
                    newSR.addView(spin1);
                    newSR.addView(txtSR2);
                    newSR.addView(spin2);
                    newSR.addView(btnD);
                    btnD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            tblLayout.removeViewAt(i);
                        }
                    });
                    tblLayout.addView(newSR);
                    //adults = spin1.getSelectedItem().toString();
                    int att = spin1.getSelectedItemPosition();

                    test1 = spin1.getSelectedItem().toString();
                    //children = spin2.getSelectedItemPosition();
                    test2 = spin2.getSelectedItem().toString();


                    //if (adults + children)

                    i++;
                }
                else {
                    Toast.makeText(AccommodationPageActivity.this, excess, Toast.LENGTH_LONG).show();
                    /*Button btnD = new Button(AccommodationPageActivity.this);
                    tblLayout.addView(btnD);
                    btnD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            tblLayout.removeAllViews();
                            i = 1;
                        }
                    });*/
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String showAccNumer = sharedPreferences.getString("accNumber"," N/A ");
                    String showAdultsNumber = sharedPreferences.getString("adultsNumber"," N/A ");
                    String showKidsNumber = sharedPreferences.getString("kidsNumber","N/A");
                    //editor.putString("accNumber",travelMonthSelection);

                    //editor.putString("adultsNumber",Integer.toString(adults));
                    //editor.putString("adultsNumber",test1);
                    //editor.putString("kidsNumber",test2);
                    //editor.putString("kidsNumber",Integer.toString(children));

                    editor.commit();



                }catch (Exception e){

                }




                //finish();
                Intent intent = new Intent(AccommodationPageActivity.this,PageSelectionActivity.class);
                startActivity(intent);

            }
        });

    }
}
