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

public class DeparturePageActivity extends AppCompatActivity {
    String depertLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depart__page);

        final CheckBox vancouverCanada= (CheckBox)findViewById(R.id.checkboxVancouverBCCanada);
        CheckBox barcelonSpain = (CheckBox)findViewById((R.id.checkboxBarcelonaSpain));
        CheckBox copenhagenDenmark = (CheckBox)findViewById(R.id.checkboxCopenhagenDenmark);
        CheckBox sanJuanPertoRico = (CheckBox)findViewById(R.id.checkboxSanJuanPuertoRico);
        CheckBox portCanaveral = (CheckBox)findViewById(R.id.checkboxPortCanaveralFlorida);
        CheckBox sanDiego = (CheckBox)findViewById(R.id.checkboxSanDiegoCalifornia);
        CheckBox HonoluluHawaii = (CheckBox)findViewById(R.id.checkboxHonoluluHawaii);
        final Button btndoneDepart = (Button)findViewById(R.id.btnDoneDepart);
        final Button btnresetDepart = (Button)findViewById(R.id.btnResetDepart);

        barcelonSpain.setEnabled(false);
        copenhagenDenmark.setEnabled(false);
        sanJuanPertoRico.setEnabled(false);
        portCanaveral.setEnabled(false);
        sanDiego.setEnabled(false);
        HonoluluHawaii.setEnabled(false);

        btndoneDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vancouverCanada.isChecked()){
                    Toast.makeText(DeparturePageActivity.this, "Vancouver Checked",Toast.LENGTH_LONG).show();
                    depertLocation = vancouverCanada.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("depart",depertLocation);
                    editor.commit();

                    Intent intent = new Intent(DeparturePageActivity.this,Page2.class);
                    startActivity(intent);

                    //finish();
                }else {

                    Toast.makeText(DeparturePageActivity.this,"Please Choose One Of This Departure Locations",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnresetDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vancouverCanada.setChecked(false);
            }

        });







    }
}
