package com.example.cruiseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.R;
import com.example.test.StateRoomTypeActivity;

public class ConfirmSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_selection);


        final Button btnConfirm = (Button) findViewById(R.id.btnConfirmGoState);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmSelectionActivity.this, StateRoomTypeActivity.class);
                startActivity(intent);

            }
        }
        );


    }
}
