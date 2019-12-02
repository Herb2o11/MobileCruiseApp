package com.example.cruiseapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.example.cruiseapp.db.entities.Destination;

@Dao
public interface DestinationDao {

    @Insert
    String insertDestination (Destination destination);

    @Update
    void updateDestination (Destination destination);

    @Delete
    void deleteDestination (Destination destination);


}
