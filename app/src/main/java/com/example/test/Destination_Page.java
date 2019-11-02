package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Destination_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination__page);
        final CheckBox alaskaCheck=(CheckBox)findViewById(R.id.checkboxAlaska);
        final Button btnDoneDestination=(Button)findViewById(R.id.btnDoneDestination);
        final CheckBox bahamascheck=(CheckBox)findViewById(R.id.checkboxBahamas);
        btnDoneDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alaskaCheck.isChecked()){
                    Toast.makeText(Destination_Page.this, "Alaska Checked",Toast.LENGTH_LONG).show();

                }else if(bahamascheck.isChecked()){
                    Toast.makeText(Destination_Page.this, "Only Alaska available right now ",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
