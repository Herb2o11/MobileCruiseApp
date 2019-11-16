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
        long i = myData.insert("users",null,contentValues);
        return  i;
    }


    //check later, used to confirm data put on users table
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from users", null);
        while (c.moveToNext()) {
            Log.d("DBX", "USERS" + c.getString(0));
        }
        return null;
    }


    public boolean checkLogin (String email, String password){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select Email , Password from Users  WHERE email = ? and Password = ?", new String[] {email,password});
        if (cursor.getCount() > 0){
            db.close();
            return  true;
        }
        else{
            db.close();
            return false;

        }

    }


}
