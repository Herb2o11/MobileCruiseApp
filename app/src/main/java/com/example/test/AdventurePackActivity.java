package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class AdventurePackActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    List<AdventurepackEntity>adventurePackageentities = new ArrayList<>();
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    String advPackPrice, extraPrice;
    Double totalPriceExtra, pricehammer , priceWhales, priceFish, priceBave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_pack);
        final CheckBox checkHammer = findViewById(R.id.checkBoxHummer);
        final CheckBox checkWahles = findViewById(R.id.checkWhales);
        final CheckBox checkFish = findViewById(R.id.checkBoxFishCamp);
        final CheckBox checkbaverage = findViewById(R.id.checkBoxbaverages);
        final Button btnAddExtra = findViewById(R.id.btnaddextra);

        linearLayout = findViewById(R.id.adv_pack_container);
        LayoutInflater inflaterAdv = getLayoutInflater();

        adventurePackageentities = Arrays.asList(
                new AdventurepackEntity(R.drawable.alaskahummer,"Alaska Hummer Adventure", "Experience Ketchikan in luxury at your pace in a private Hummer H2® and a skilled driver-guide at your service.",650),
                new AdventurepackEntity(R.drawable.alaskawhales1,"Alaska Whales and Science Adventure","Enjoy whale watching, glacier viewing and insightful science activities as you record observations and help out researchers",200),
                new AdventurepackEntity(R.drawable.alaskanfishcamp1,"Alaske Fish Camp", "Angle for rockfish, red snapper, cod and even salmon before having your catch cooked as a part of a fish feast.",380),
                new AdventurepackEntity(R.drawable.baveragetastings,"Baverage Tastings", "Discover libation tastings that take you from Amari to Whiskey—with an assortment of pleasurable beverages in between! ", 90)

        );

        for (AdventurepackEntity adventurepackEntity :adventurePackageentities){

            View view = inflaterAdv.inflate(R.layout.adventure_pack_row, linearLayout, false);

            ImageView imageView = view.findViewById(R.id.advheaderImage);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AdventurePackActivity.this,"testimageclick",Toast.LENGTH_SHORT).show();

                }
            });
            //TextView txtName = view.findViewById(R.id.txt_room_info);
            TextView txtAdvName = view.findViewById(R.id.txt_adv_name);
            TextView txtadvInfo = view.findViewById(R.id.txt_adv_info);
            TextView txtadvPrice = view.findViewById(R.id.txt_adventure_price);

            imageView.setImageDrawable(getResources().getDrawable(adventurepackEntity.getAdvImage()));
            txtAdvName.setText(adventurepackEntity.getName());
            txtadvInfo.setText(adventurepackEntity.getDescription());
            txtadvPrice.setText(numberFormat.format(adventurepackEntity.getAdvPrice()));




            linearLayout.addView(view);



        }
        if (checkHammer.isChecked()){
            pricehammer = 650.0;
            //priceWhales = 200.0;
            //priceFish = 380.0;
            //priceBave = 90.0;

        }
        if (checkWahles.isChecked()){
            //pricehammer = 650.0;
            priceWhales = 200.0;
            //priceFish = 380.0;
            //priceBave = 90.0;

        }
        if (checkFish.isChecked()){
            //pricehammer = 650.0;
            //priceWhales = 200.0;
            //priceFish = 380.0;
            priceBave = 90.0;

        }
        if (checkbaverage.isChecked()){
            //pricehammer = 650.0;
            //priceWhales = 200.0;
            //priceFish = 380.0;
            priceBave = 90.0;

        }

        btnAddExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    totalPriceExtra = pricehammer + priceWhales + priceFish + priceBave;
                    extraPrice = totalPriceExtra.toString();
                }catch (Exception e){

                }

                SharedPreferences sharedPreferences = getSharedPreferences("dataShared",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ExtraValue",extraPrice);
                editor.apply();
                Intent intent = new Intent(AdventurePackActivity.this,InvoiceActivity.class);
                startActivity(intent);
            }
        });

    }
}