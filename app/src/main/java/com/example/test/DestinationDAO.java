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

public class DestinationDAO extends CruiseDataBase{

    public DestinationDAO(@Nullable Context context) {
        super(context);
    }

    public long storeDestination (DestinationEntity destinationEntity){
        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("destinationID",destinationEntity.getDestinationID());
        contentValues.put("destination",destinationEntity.getDestination());

        long storeDestination = myData.insert("DESTINATION",null,contentValues);
        return storeDestination;


    }

}
