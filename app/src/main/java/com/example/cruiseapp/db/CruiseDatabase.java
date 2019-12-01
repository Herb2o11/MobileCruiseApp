package com.example.cruiseapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.cruiseapp.db.dao.StateRoomDao;
import com.example.cruiseapp.db.dao.UserDao;
import com.example.cruiseapp.db.entities.StateRoom;
import com.example.cruiseapp.db.entities.User;

@Database(entities = {
            User.class,
        StateRoom.class
        },
          exportSchema = false,

          version = 7)

public abstract class CruiseDatabase extends RoomDatabase {
    private static final String DB_NAME = "cruise_db";
    private static CruiseDatabase instance;

    public abstract UserDao userDao();
    public abstract StateRoomDao stateRoomDao();

    public static synchronized CruiseDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), CruiseDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
