package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends CruiseDataBase {


    public UserDAO(@Nullable Context context) {
        super(context);
    }


    //Creating queries for Register page
    public long registerUser(User u){
        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email",u.getEmail() );
        contentValues.put("Name",u.getName());
        contentValues.put("Phone",u.getPhone());
        contentValues.put("Address",u.getAddress());
        contentValues.put("Password",u.getPassword());
        long i = myData.insert("User_Table",null,contentValues);
        return  i;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from user_table", null);
        if(c.getCount() > 0) {
            Log.d("DBX", "USER" + c.getString(1));
        } else {
            Log.d("DBX", "NOBODY");
        }
        return null;
    }


}
