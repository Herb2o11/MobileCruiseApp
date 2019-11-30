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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DateSelectionActivity extends AppCompatActivity {

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
    String travelMonthSelection;
    String dayselected;

    RadioGroup radioGroup;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    CheckBox btn2nd, btn11th, btn21st;

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


        btn2nd = findViewById(R.id.checkBoxDay2nd);
        btn11th = findViewById(R.id.checkBoxDay11th);
        btn21st = findViewById(R.id.checkBoxDay21st);


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
                        Toast.makeText(DateSelectionActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                        travelMonthSelection = radioButton.getText().toString();
                        break;
                    }
                }

                if(btn2nd.isChecked()){
                    dayselected  = btn2nd.getText().toString();
                } else if (btn11th.isChecked()){
                    dayselected  = btn11th.getText().toString();
                }else if (btn21st.isChecked()){
                    dayselected  = btn21st.getText().toString();
                }

                SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("month",travelMonthSelection);
                editor.putString("daySelected",dayselected);

                editor.commit();

                Intent intent = new Intent(DateSelectionActivity.this, PageSelectionActivity.class);
                startActivity(intent);

            }
        });

    }

}