package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Destination_Page extends AppCompatActivity {

    String departSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination__page);
        final CheckBox alaskaCheck=(CheckBox)findViewById(R.id.checkboxAlaska);
        final Button btnDoneDestination=(Button)findViewById(R.id.btnDoneDestination);
        Button btnReset=(Button)findViewById(R.id.btnResetDestination);
        final CheckBox bahamasCheck=(CheckBox)findViewById(R.id.checkboxBahamas);
        CheckBox bermudaCheck=(CheckBox)findViewById(R.id.checkboxBermuda);
        CheckBox caribbeanCheck=(CheckBox)findViewById(R.id.checkboxCaribbean);
        CheckBox europeCheck=(CheckBox)findViewById(R.id.checkboxEurope);
        CheckBox hawaiiCheck=(CheckBox)findViewById(R.id.checkboxHawaii);
        CheckBox mexicoCheck=(CheckBox)findViewById(R.id.checkboxMexico);
        //to make other checkBoxes unavailable
        bahamasCheck.setEnabled(false);
        bermudaCheck.setEnabled(false);
        caribbeanCheck.setEnabled(false);
        europeCheck.setEnabled(false);
        hawaiiCheck.setEnabled(false);
        mexicoCheck.setEnabled(false);

        btnDoneDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alaskaCheck.isChecked()){
                    departSelected = alaskaCheck.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("dest",departSelected);
                    editor.commit();

                    Toast.makeText(Destination_Page.this, "Alaska Checked",Toast.LENGTH_LONG).show();
                    //finish();
                    Intent intent = new Intent(Destination_Page.this,Page2.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Destination_Page.this,"Please Choose One Of This Destinations",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alaskaCheck.setChecked(false);
            }
        });


    }
}
