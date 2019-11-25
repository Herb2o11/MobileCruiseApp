package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;



public class AdventurePackActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    List<AdventurepackEntity>adventurePackageentities = new ArrayList<>();
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_pack);


    }
}
