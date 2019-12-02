package com.example.cruiseapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cruiseapp.db.entities.Dates;

import java.util.Date;

@Dao
public interface DatesDao {

    @Insert
    String insertMonth (Dates dates);

    @Insert
    String insertDepartOptionas(Dates dates);


    @Query("select * from dates_table where id = :id limit 1")
    Dates getDates (long id);

    @Update
    void upDateDates (Dates dates);

    @Delete
    void deleteDates (Dates dates);


}
