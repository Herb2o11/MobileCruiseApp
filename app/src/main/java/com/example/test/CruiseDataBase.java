package com.example.test;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;



public class CruiseDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="DisneyCruise.db";
    public static final String USER_TABLE_="User_Table";
    public static final String DATES_TABLE="Dates_Table";
    public static final String DESTINATION_TABLE="Destination_Table";
    public static final String STATEROOM_TABLE ="State_Room_Table";
    public static final String ACOMODATION_TRAVELPARTY_TABLE="Travel_Party_Table";
    public static final String DEPART_TABLE="Depart_Table";
    public static final String SHIPLOCATION_TABLE="ShipLocation_Table";
    public static final String ADVENTUREPACK_TABLE="AdventurePack_Table";
    public static final String ORDER_TABLE="Order_Table";
    public static final String PAYMENT_TABLE="Payment_Table";


    public CruiseDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    //db.execSQL("create table " + TABLE_NAME+" (USERID INTEGER PRIMARY KEY AUTOINCREMENT,USER_NAME TEXT,USER_LAST_NAME TEXT ,USER_DATE_ID INTEGER)");
      db.execSQL(TableDefinition.SQL_CREATE_USER_TABLE);

      //tables need to be created avoiding the foreign key problem


      db.execSQL(TableDefinition.SQL_CREATE_DATES_TABLE);
      /*
      db.execSQL(TableDefinition.SQL_CREATE_DESTINATION_TABLE);
      db.execSQL(TableDefinition.SQL_CREATE_ACOMODATION_TRAVELPARTY_TABLE);
      db.execSQL(TableDefinition.SQL_CREATE_STATEROOM_TABLE);
      db.execSQL(TableDefinition.SQL_CREATE_DEPART_TABLE);
      db.execSQL(TableDefinition.SQL_CREATE_SHIPLOCATION_TABLE);
      db.execSQL(TableDefinition.SQL_CREATE_ADVENTUREPACK);
      db.execSQL(TableDefinition.SQL_CREATE_ORDER);
      db.execSQL(TableDefinition.SQL_CREATE_PAYMENT);
      */
      Log.d("CruiseDataBase","onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TableDefinition.SQL_DELETE_USER_TABLE);

        db.execSQL(TableDefinition.SQL_DELETE_DATES_TABLE);
        /*
        db.execSQL(TableDefinition.SQL_DELETE_DESTINATION_TABLE);
        db.execSQL(TableDefinition.SQL_DELETE_ACOMODATION_TRAVELPARTY_TABLE);
        db.execSQL(TableDefinition.SQL_DELETE_STATEROOM_TABLE);
        db.execSQL(TableDefinition.SQL_DELETE_DEPART_TABLE);
        db.execSQL(TableDefinition.SQL_DELETE_SHIPLOCATION_TABLE);
        db.execSQL(TableDefinition.SQL_DELETE_ADVENTUREPACK);
        db.execSQL(TableDefinition.SQL_DELETE_ORDER);
        db.execSQL(TableDefinition.SQL_DELETE_PAYMENT);
        */
        Log.d("CruiseDataBase","onUpgrade");


    }




}
