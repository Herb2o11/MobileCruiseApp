package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class AdventurePackDAO extends CruiseDataBase{

    public AdventurePackDAO(@Nullable Context context) {
        super(context);
    }

    public long storeAdventurePack (AdventurePackDbEntity adventurePackDbEntity) {
        SQLiteDatabase mydata = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("activityName",adventurePackDbEntity.getActivityName());
        contentValues.put("activityID",adventurePackDbEntity.getActivityID());
        contentValues.put("addChildrenPrice",adventurePackDbEntity.getAddChildrenPrice());
        contentValues.put("activityPrice",adventurePackDbEntity.getActivityPrice());

        long storeAdventurePack =mydata.insert("ADVENTUREPACK",null,contentValues);
        return storeAdventurePack;
    }


}
