package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DepartureDAO extends CruiseDataBase {

    public DepartureDAO(@Nullable Context context) {
        super(context);
    }

    public long storeDepart (DepartureEntity departureEntity){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase myData = this.getWritableDatabase();
        contentValues.put("departId",departureEntity.getDepartId());
        contentValues.put("departLocation",departureEntity.getDepartLocation());

        long storeDepart = myData.insert("DEPART",null,contentValues);
        return storeDepart;


    }
}
