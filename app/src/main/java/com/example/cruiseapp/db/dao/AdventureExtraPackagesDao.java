package com.example.cruiseapp.db.dao;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cruiseapp.db.entities.AdventureExtraPackages;

@Dao
public interface AdventureExtraPackagesDao {

    @Insert
    String insertActivityName (AdventureExtraPackages adventureExtraPackages);

    @Insert
    String insertPrice (AdventureExtraPackages adventureExtraPackages);

    @Update
    void updateAdventureExtraPackages (AdventureExtraPackages adventureExtraPackages);

    @Delete
    void deleteAdventureExtraPackages (AdventureExtraPackages adventureExtraPackages);


}
