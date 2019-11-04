package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

public class DateSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);

        String travelMonthSelection;
        CheckBox checkDate1 = (CheckBox) findViewById(R.id.checkBoxDate1);
        CheckBox checkDate2 = (CheckBox) findViewById(R.id.checkBoxDate2);
        CheckBox checkDate3 = (CheckBox) findViewById(R.id.checkBoxDate3);
        CheckBox checkDate4 = (CheckBox) findViewById(R.id.checkBoxDate4);
        CheckBox checkDate5 = (CheckBox) findViewById(R.id.checkBoxDate5);
        CheckBox checkDate6 = (CheckBox) findViewById(R.id.checkBoxDate6);
        CheckBox checkDate7 = (CheckBox) findViewById(R.id.checkBoxDate7);
        CheckBox checkDate8 = (CheckBox) findViewById(R.id.checkBoxDate8);
        CheckBox checkDate9 = (CheckBox) findViewById(R.id.checkBoxDate9);
        CheckBox checkDate10 = (CheckBox) findViewById(R.id.checkBoxDate10);
        CheckBox checkDate11= (CheckBox) findViewById(R.id.checkBoxDate11);
        CheckBox checkDate12= (CheckBox) findViewById(R.id.checkBoxDate12);


        //best time to visit may to September
        checkDate1.setEnabled(false);
        checkDate2.setEnabled(false);
        checkDate3.setEnabled(false);
        checkDate4.setEnabled(false);
        checkDate10.setEnabled(false);
        checkDate11.setEnabled(false);
        checkDate12.setEnabled(false);

        if(checkDate5.isChecked()){
            travelMonthSelection = checkDate5.toString();


        }





    }
}
