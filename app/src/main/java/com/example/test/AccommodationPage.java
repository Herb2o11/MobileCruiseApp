package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AccommodationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation_page);

        TableLayout tblLayout = (TableLayout) findViewById(R.id.tableLayout);

        TableRow row1 = new TableRow(this);
        TextView txtV1 = new TextView(this);
        TextView txtV2 = new TextView(this);
        TextView txtV3 = new TextView(this);
        txtV1.setText("Stateroom 1");
        txtV2.setText("\nAdults: ");
        txtV3.setText("\nChildren: ");
        row1.addView(txtV1);
        row1.addView(txtV2);
        row1.addView(txtV3);
        tblLayout.addView(row1);

    }
}
