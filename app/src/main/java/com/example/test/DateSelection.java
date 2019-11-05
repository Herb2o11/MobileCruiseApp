package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DateSelection extends AppCompatActivity {
    String travelMonthSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);


        CheckBox checkDate1 = (CheckBox) findViewById(R.id.checkBoxDate1);
        CheckBox checkDate2 = (CheckBox) findViewById(R.id.checkBoxDate2);
        CheckBox checkDate3 = (CheckBox) findViewById(R.id.checkBoxDate3);
        CheckBox checkDate4 = (CheckBox) findViewById(R.id.checkBoxDate4);
        final CheckBox checkDate5 = (CheckBox) findViewById(R.id.checkBoxDate5);
        final CheckBox checkDate6 = (CheckBox) findViewById(R.id.checkBoxDate6);
        final CheckBox checkDate7 = (CheckBox) findViewById(R.id.checkBoxDate7);
        final CheckBox checkDate8 = (CheckBox) findViewById(R.id.checkBoxDate8);
        final CheckBox checkDate9 = (CheckBox) findViewById(R.id.checkBoxDate9);
        CheckBox checkDate10 = (CheckBox) findViewById(R.id.checkBoxDate10);
        CheckBox checkDate11= (CheckBox) findViewById(R.id.checkBoxDate11);
        CheckBox checkDate12= (CheckBox) findViewById(R.id.checkBoxDate12);
        Button btnDoneDate = (Button) findViewById(R.id.btnDoneDateSelection);
        Button btnResetDate = (Button) findViewById(R.id.btnResetDateSelection);



        //best time to visit may to September
        checkDate1.setEnabled(false);
        checkDate2.setEnabled(false);
        checkDate3.setEnabled(false);
        checkDate4.setEnabled(false);
        checkDate10.setEnabled(false);
        checkDate11.setEnabled(false);
        checkDate12.setEnabled(false);

        btnDoneDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkDate5.isChecked()) {
                    travelMonthSelection = checkDate5.toString();
                    Toast.makeText(DateSelection.this, "May Checked", Toast.LENGTH_LONG).show();
                    finish();
                } else if (checkDate6.isChecked()) {
                    travelMonthSelection = checkDate6.toString();
                    Toast.makeText(DateSelection.this, "June Checked", Toast.LENGTH_LONG).show();
                    finish();
                }else if(checkDate7.isChecked()){
                    travelMonthSelection = checkDate7.toString();
                    Toast.makeText(DateSelection.this, "July Checked", Toast.LENGTH_LONG).show();
                    finish();
                }else if(checkDate8.isChecked()){
                    travelMonthSelection = checkDate8.toString();
                    Toast.makeText(DateSelection.this, "August Checked", Toast.LENGTH_LONG).show();
                    finish();
                }else if (checkDate9.isChecked()){
                    travelMonthSelection = checkDate9.toString();
                    Toast.makeText(DateSelection.this, "September Checked", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(DateSelection.this, "Please Select a month for the Cruise", Toast.LENGTH_LONG).show();
                }
            }
        });
                checkDate5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     checkDate6.setChecked(false);
                     checkDate7.setChecked(false);
                     checkDate8.setChecked(false);
                     checkDate9.setChecked(false);
                    }
                });

                checkDate6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkDate5.setChecked(false);
                        checkDate7.setChecked(false);
                        checkDate8.setChecked(false);
                        checkDate9.setChecked(false);
                    }
                });

                checkDate7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkDate5.setChecked(false);
                        checkDate6.setChecked(false);
                        checkDate8.setChecked(false);
                        checkDate9.setChecked(false);
                    }
                });

                checkDate8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkDate5.setChecked(false);
                        checkDate6.setChecked(false);
                        checkDate7.setChecked(false);
                        checkDate9.setChecked(false);
                    }
                });

                checkDate9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkDate5.setChecked(false);
                        checkDate6.setChecked(false);
                        checkDate7.setChecked(false);
                        checkDate8.setChecked(false);
                    }
                });

                btnResetDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkDate5.setChecked(false);
                        checkDate6.setChecked(false);
                        checkDate7.setChecked(false);
                        checkDate8.setChecked(false);
                        checkDate9.setChecked(false);
                    }
                });






    }

}