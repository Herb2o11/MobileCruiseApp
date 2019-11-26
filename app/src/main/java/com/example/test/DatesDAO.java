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

public class DatesDAO extends CruiseDataBase {

    public DatesDAO(@Nullable Context context) {
        super(context);
    }

    public long selectDate (DateEntity dateEntity) {
        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dateID",dateEntity.getDateID());
        contentValues.put("month",dateEntity.getMonth());
        contentValues.put("depart_dates",dateEntity.getDepart_dates());

        long storeDate = myData.insert("DATE",null,contentValues);
        return storeDate;
    }

}
