package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DateSelection extends AppCompatActivity {
    String travelMonthSelection;

    RadioGroup radioGroup;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;

    RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                radioGroup2.setOnCheckedChangeListener(null); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
                radioGroup2.clearCheck(); // clear the second RadioGroup!
                radioGroup2.setOnCheckedChangeListener(listener2); //reset the listener
            }
        }
    };
    RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                radioGroup1.setOnCheckedChangeListener(null); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
                radioGroup1.clearCheck(); // clear the second RadioGroup!
                radioGroup1.setOnCheckedChangeListener(listener1); //reset the listener
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);

        Button btnDoneDate = (Button) findViewById(R.id.btnDoneDateSelection);
        Button btnResetDate = (Button) findViewById(R.id.btnResetDateSelection);
        radioGroup = findViewById(R.id.radio_group);
        radioGroup1 = findViewById(R.id.radio_group1);
        radioGroup2 = findViewById(R.id.radio_group2);

        radioGroup1.setOnCheckedChangeListener(listener1);
        radioGroup2.setOnCheckedChangeListener(listener2);

/*        CheckBox checkDate1 = (CheckBox) findViewById(R.id.checkBoxDate1);
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
        Button btnResetDate = (Button) findViewById(R.id.btnResetDateSelection);*/



        //best time to visit may to September
/*        checkDate1.setEnabled(false);
        checkDate2.setEnabled(false);
        checkDate3.setEnabled(false);
        checkDate4.setEnabled(false);
        checkDate10.setEnabled(false);
        checkDate11.setEnabled(false);
        checkDate12.setEnabled(false);*/

        btnDoneDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<RadioGroup> radioGroups = new ArrayList<>();
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    radioGroups.add((RadioGroup) radioGroup.getChildAt(i));
                }
                for (RadioGroup tmpRadioGroup : radioGroups) {
                    int checkedId = tmpRadioGroup.getCheckedRadioButtonId();
                    if(checkedId != -1) {
                        RadioButton radioButton = tmpRadioGroup.findViewById(checkedId);
                        Toast.makeText(DateSelection.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });

    }

}