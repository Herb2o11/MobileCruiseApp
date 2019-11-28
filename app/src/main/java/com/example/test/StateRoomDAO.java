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

public class StateRoomDAO extends CruiseDataBase {

    public StateRoomDAO(@Nullable Context context) {
        super(context);
    }

    public long storeStateRoom (StateRoomDbEntity stateRoomDbEntity) {
        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("roomId",stateRoomDbEntity.getRoomId());
        contentValues.put("roomCategory",stateRoomDbEntity.getRoomCategory());
        contentValues.put("roomLocation",stateRoomDbEntity.getRoomLocation());
        contentValues.put("roomType",stateRoomDbEntity.getRoomType());
        contentValues.put("room_Price",stateRoomDbEntity.getRoom_Price());

        long storeDate = myData.insert("STATEROOM",null,contentValues);
        return storeDate;

    }

}
