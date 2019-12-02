//package com.example.test;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//
//public class ShipLocationActivity extends AppCompatActivity {
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater=getMenuInflater();
//        menuInflater.inflate(R.menu.redirection_menu, menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case R.id.go_to_Create:
//                Intent intentTOPageSelection=new Intent(getApplicationContext(), PageSelectionActivity.class);
//                startActivity(intentTOPageSelection);
//                return true;
//
//            case R.id.go_to_Existing:
//                Intent intentToExisting=new Intent(getApplicationContext(), ExistingUserActivity.class);
//                startActivity(intentToExisting);
//                return true;
//
//            default:
//                super.onOptionsItemSelected(item);
//        }
//        if(item.getItemId()==R.id.go_to_Existing){
//            Intent intent=new Intent(getApplicationContext(), ExistingUserActivity.class);
//            startActivity(intent);
//            return true;
//        }
//        return false;
//    }
//
//    Button btnAft, btnMid, btnForward, btnDeck1Aft, btnDeck2Aft, btnDeck1Mid, btnDeck2Mid,
//            btnDeck1Forward, btnDeck2Forward;
//
//    String shipLoc;
//    String deckNumberAndAmount;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ship_location);
//        //to connect buttons
//        btnAft=findViewById(R.id.btnAft);
//        btnMid=findViewById(R.id.btnMidShip);
//        btnForward=findViewById(R.id.btnForward);
//
//        //Deck buttons
//        btnDeck1Aft=findViewById(R.id.btnDeck1Aft);
//        btnDeck2Aft=findViewById(R.id.btnDeck2Aft);
//
//        btnDeck1Mid=findViewById(R.id.btnDeck1Mid);
//        btnDeck2Mid=findViewById(R.id.btnDeck2Mid);
//
//        btnDeck1Forward=findViewById(R.id.btnDeck1Forward);
//        btnDeck2Forward=findViewById(R.id.btnDeck2Forward);
//
//        btnAft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btnDeck1Aft.setVisibility(View.VISIBLE);
//                btnDeck2Aft.setVisibility(View.VISIBLE);
//
//                btnDeck1Mid.setVisibility(View.INVISIBLE);
//                btnDeck2Mid.setVisibility(View.INVISIBLE);
//
//                btnDeck1Forward.setVisibility(View.INVISIBLE);
//                btnDeck2Forward.setVisibility(View.INVISIBLE);
//            }
//        });
//
//        btnMid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btnDeck1Mid.setVisibility(View.VISIBLE);
//                btnDeck2Mid.setVisibility(View.VISIBLE);
//
//                btnDeck1Aft.setVisibility(View.INVISIBLE);
//                btnDeck2Aft.setVisibility(View.INVISIBLE);
//
//                btnDeck1Forward.setVisibility(View.INVISIBLE);
//                btnDeck2Forward.setVisibility(View.INVISIBLE);
//
//            }
//        });
//
//        btnForward.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btnDeck1Forward.setVisibility(View.VISIBLE);
//                btnDeck2Forward.setVisibility(View.VISIBLE);
//
//                btnDeck1Aft.setVisibility(View.INVISIBLE);
//                btnDeck2Aft.setVisibility(View.INVISIBLE);
//
//                btnDeck1Mid.setVisibility(View.INVISIBLE);
//                btnDeck2Mid.setVisibility(View.INVISIBLE);
//
//            }
//        });
//
//        btnDeck1Forward.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent iForwardDeck1=new Intent(ShipLocationActivity.this, SelectRoomForwardDeck1Activity.class);
//                startActivity(iForwardDeck1);
//                shipLoc=btnForward.getText().toString();
//                deckNumberAndAmount=btnDeck1Forward.getText().toString();
////                Intent intentToInvoicePage=new Intent(this,);
////                startActivity(intentToInvoicePage);
//            }
//        });
//
//        btnDeck2Forward.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iForwardDeck2=new Intent(ShipLocationActivity.this, SelectRoomForwardDeck2Activity.class);
//                startActivity(iForwardDeck2);
//                shipLoc=btnForward.getText().toString();
//                deckNumberAndAmount=btnDeck2Forward.getText().toString();
//
//            }
//        });
//
//        btnDeck1Mid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iMidDeck1=new Intent(ShipLocationActivity.this, SelectRoomMidShipDeck1Activity.class);
//                startActivity(iMidDeck1);
//                shipLoc=btnMid.getText().toString();
//                deckNumberAndAmount=btnDeck1Mid.getText().toString();
//            }
//        });
//
//        btnDeck2Mid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iMidDeck2=new Intent(ShipLocationActivity.this, SelectRoomMidShipDeck2Activity.class);
//                startActivity(iMidDeck2);
//                shipLoc=btnMid.getText().toString();
//                deckNumberAndAmount=btnDeck2Mid.getText().toString();
//            }
//        });
//
//        btnDeck1Aft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iAftDeck1=new Intent(ShipLocationActivity.this, SelectRoomAftDeck.class);
//                startActivity(iAftDeck1);
//                shipLoc=btnAft.getText().toString();
//                deckNumberAndAmount=btnDeck1Aft.getText().toString();
//            }
//        });
//
//        btnDeck2Aft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iAftDeck2=new Intent(ShipLocationActivity.this, SelectRoomAftDeck2.class);
//                startActivity(iAftDeck2);
//                shipLoc=btnAft.getText().toString();
//                deckNumberAndAmount=btnDeck2Aft.getText().toString();
//            }
//        });
//
//        SharedPreferences sharedPreferences=getSharedPreferences("dataShared", MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("shipLoc", shipLoc);
//        editor.putString("deckSelected", deckNumberAndAmount);
//        editor.apply();
//    }
//
//}
