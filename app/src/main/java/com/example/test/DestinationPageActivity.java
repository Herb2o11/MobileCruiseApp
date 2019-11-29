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
import android.widget.Toast;

public class DestinationPageActivity extends AppCompatActivity {

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

                    Toast.makeText(DestinationPageActivity.this, "Alaska Checked",Toast.LENGTH_LONG).show();
                    //finish();
                    Intent intent = new Intent(DestinationPageActivity.this, PageSelectionActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(DestinationPageActivity.this,"Please Choose One Of This Destinations",Toast.LENGTH_LONG).show();
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
