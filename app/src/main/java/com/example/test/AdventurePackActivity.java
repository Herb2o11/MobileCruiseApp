package com.example.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    LinearLayout linearLayout;
    List<AdventurepackEntity>adventurePackageentities = new ArrayList<>();
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_pack);

        Button btnaddextra=findViewById(R.id.btnaddextra);
        final CheckBox checkBoxHummer=findViewById(R.id.checkBoxHummer);
        final CheckBox checkWhales=findViewById(R.id.checkWhales);
        final CheckBox checkBoxFishCamp=findViewById(R.id.checkBoxFishCamp);
        final CheckBox checkBoxbaverages=findViewById(R.id.checkBoxbaverages);


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

        btnaddextra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((checkBoxHummer.isChecked() || checkWhales.isChecked()) || (checkBoxFishCamp.isChecked() || checkBoxbaverages.isChecked())){
                    Intent intentInvoice=new Intent(AdventurePackActivity.this, InvoiceActivity.class);
                    startActivity(intentInvoice);
                }else{
                    Toast.makeText(AdventurePackActivity.this, "Please Choose One Of This Packages", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
