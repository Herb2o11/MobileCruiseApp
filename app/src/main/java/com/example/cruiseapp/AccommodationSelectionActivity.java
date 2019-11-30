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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.test.DateSelectionActivity;
import com.example.test.ExistingUserActivity;
import com.example.test.PageSelectionActivity;
import com.example.test.R;

public class AccommodationSelectionActivity extends AppCompatActivity {

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

    String adultsselected, childSelected;

    String selectedAdult1, selectedchild1;
    String selectedAdult2, selectedchild2;
    String nStateRoom;
    int valueAdult1, valueChild1, valueAdult2, valueChild2;
    int totalA, totalC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation_selection);

        final TextView txt2Adult = findViewById(R.id.textView23);
        final TextView txt2Child = findViewById(R.id.textView24);
        //////////////////////////////////////////
        final Button btnSubmit = findViewById(R.id.btnAccSubmit);
        final Button btnClear = findViewById(R.id.btnAccClear);
        final Button btnAddState = findViewById(R.id.btnAccAdd);
        ///////////////////////////////////////////
        final RadioGroup radio1Adult = findViewById(R.id.radioGroup);
        final RadioGroup radio1Child = findViewById(R.id.radioGroup2);
        final RadioGroup radio2Adult = findViewById(R.id.radioGroup3);
        final RadioGroup radio2Child = findViewById(R.id.radioGroup4);
        ///////////////////////////////////////////
        final RadioButton radio1Adult2 =findViewById(R.id.radioButton3);
        final RadioButton radio1Adult3 =findViewById(R.id.radioButton4);
        final RadioButton radio1Adult4 =findViewById(R.id.radioButton5);
        ///////////////////////////////////////////
        final RadioButton radio1Child0 = findViewById(R.id.radioButton7);
        final RadioButton radio1Child1 = findViewById(R.id.radioButton8);
        final RadioButton radio1Child2 = findViewById(R.id.radioButton9);
        final RadioButton radio1Child3 = findViewById(R.id.radioButton10);
        final RadioButton radio1Child4 = findViewById(R.id.radioButton11);
        //////////////////////////////////////////////
        final RadioButton radio2Adult2 = findViewById(R.id.radioButton12);
        final RadioButton radio2Adult3 = findViewById(R.id.radioButton13);
        final RadioButton radio2Adult4 = findViewById(R.id.radioButton14);
        //////////////////////////////////////////////
        final RadioButton radio2Child0 = findViewById(R.id.radioButton16);
        final RadioButton radio2Child1= findViewById(R.id.radioButton17);
        final RadioButton radio2Child2 = findViewById(R.id.radioButton18);
        final RadioButton radio2Child3 = findViewById(R.id.radioButton19);
        final RadioButton radio2Child4 = findViewById(R.id.radioButton20);


        radio2Adult.setVisibility(View.INVISIBLE);
        radio2Child.setVisibility(View.INVISIBLE);
        txt2Adult.setVisibility(View.INVISIBLE);
        txt2Child.setVisibility(View.INVISIBLE);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for the adults radiogroup 1
                int selectedRadioButtonIDAdult1 = radio1Adult.getCheckedRadioButtonId();
                // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonIDAdult1 != -1) {

                    nStateRoom = "1";
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonIDAdult1);
                    selectedAdult1 = selectedRadioButton.getText().toString();
                    valueAdult1 = Integer.parseInt(selectedAdult1);
                }

                int selectedRadioButtonIDChild1 = radio1Child.getCheckedRadioButtonId();

                // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonIDChild1 != -1) {

                    RadioButton selectedRadioButton1 = findViewById(selectedRadioButtonIDChild1);
                    selectedchild1 = selectedRadioButton1.getText().toString();
                    valueChild1 = Integer.parseInt(selectedchild1);
                }


                try {
                    //if (radio2Adult.isActivated() && radio2Child.isActivated()) {
                        //nStateRoom = "2";
                        int selectedRadioButtonIDAdult2 = radio2Adult.getCheckedRadioButtonId();
                        // If nothing is selected from Radio Group, then it return -1
                        if (selectedRadioButtonIDAdult2 != -1) {

                            RadioButton selectedRadioButton = findViewById(selectedRadioButtonIDAdult2);
                            selectedAdult2 = selectedRadioButton.getText().toString();
                            valueAdult2 = Integer.parseInt(selectedAdult2);
                        }
                    //}

                    int selectedRadioButtonIDChild2 = radio2Child.getCheckedRadioButtonId();
                    if (selectedRadioButtonIDChild2 != -1) {

                        RadioButton selectedRadioButton1 = findViewById(selectedRadioButtonIDChild2);
                        selectedchild2 = selectedRadioButton1.getText().toString();
                        valueChild2 = Integer.parseInt(selectedchild2);



                    }

                    if( valueAdult2 !=  0 || valueChild2 != 0 ){
                        nStateRoom = "2";
                    }


                } catch (Exception e) {
                }


                totalA = valueAdult1 + valueAdult2;
                totalC = valueChild1 + valueChild2;
                adultsselected= String.valueOf(totalA);
                childSelected = String.valueOf(totalC); ;


                SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nState",nStateRoom);
                editor.putString("adults",adultsselected);
                editor.putString("kids",childSelected);

                editor.commit();

                Intent intent = new Intent(AccommodationSelectionActivity.this, PageSelectionActivity.class);
                startActivity(intent);
            }
        });

        btnAddState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radio2Adult.setVisibility(View.VISIBLE);
                radio2Child.setVisibility(View.VISIBLE);
                txt2Adult.setVisibility(View.VISIBLE);
                txt2Child.setVisibility(View.VISIBLE);



            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radio1Adult.clearCheck();
                radio2Adult.clearCheck();
                radio1Child.clearCheck();
                radio2Child.clearCheck();

                //Turning second stateroom invisible again
                radio2Adult.setVisibility(View.INVISIBLE);
                radio2Child.setVisibility(View.INVISIBLE);
                txt2Adult.setVisibility(View.INVISIBLE);
                txt2Child.setVisibility(View.INVISIBLE);

            }
        });




    }
}
