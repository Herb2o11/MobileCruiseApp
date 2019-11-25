package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_pack);

        linearLayout = findViewById(R.id.adv_pack_container);
        LayoutInflater inflaterAdv = getLayoutInflater();

        adventurePackageentities = Arrays.asList(
                new AdventurepackEntity(R.drawable.alaskahummer,"Alaska Hummer Adventure", "Experience Ketchikan in luxury at your pace in a private Hummer H2® and a skilled driver-guide at your service.",650),
                new AdventurepackEntity(R.drawable.alaskawhales1,"Alaska Whales and Science Adventure","Enjoy whale watching, glacier viewing and insightful science activities as you record observations and help out researchers",200),
                new AdventurepackEntity(R.drawable.alaskanfishcamp1,"Alaske Fish Camp", "Angle for rockfish, red snapper, cod and even salmon before having your catch cooked as a part of a fish feast.",380)
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
            txtadvPrice.setText(numberFormat.format(adventurepackEntity.getAdvImage()));

            linearLayout.addView(view);



        }



    }
}
