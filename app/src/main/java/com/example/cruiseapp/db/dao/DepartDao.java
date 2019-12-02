package com.example.cruiseapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cruiseapp.db.entities.Dates;
import com.example.cruiseapp.db.entities.Depart;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;

@Dao
public interface DepartDao {

    @Insert
    String insertDepartLocation (Depart depart);

    @Update
    void updateDepart (Depart  depart);

    @Delete
    void deleteDepart (Depart depart);


}
