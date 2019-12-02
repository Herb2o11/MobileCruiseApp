package com.example.cruiseapp;

import android.app.Application;
import android.util.Log;

import com.example.cruiseapp.db.CruiseDatabase;
import com.example.cruiseapp.db.entities.StateRoom;
import com.example.cruiseapp.helpers.CSVHandler;

import java.util.List;

public class CruiseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CruiseDatabase cruiseDatabase = CruiseDatabase.getInstance(this);

        CSVHandler csvHandler = new CSVHandler();
        try {
            List<StateRoom> stateRooms = csvHandler.read(this, "stateroomtable.csv");
            if(cruiseDatabase.stateRoomDao().getStateRooms().size() == 0) {
                cruiseDatabase.stateRoomDao().insertAllStateRoom(stateRooms);
            }
        } catch (Exception ex) {
            Log.d("DBX", ex.getMessage());
        }

        // TODO Read csv and insert into database
    }
}
