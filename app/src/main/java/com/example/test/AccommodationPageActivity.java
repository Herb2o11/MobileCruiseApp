package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    int i = 1;
    int adults, children;
    String excess = "If you would like to book more than 4 staterooms for the same cruise, please make multiple reservations.";

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
                if (i <= 4) {
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
                    adults = spin1.getSelectedItemPosition();
                    children = spin2.getSelectedItemPosition();

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


                finish();
            }
        });

    }
}
