package com.example.cruiseapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "depart_table" )
public class Depart {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "depart_location")
    String departLocation;

    public Depart(long id, String departLocation) {
        this.id = id;
        this.departLocation = departLocation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartLocation() {
        return departLocation;
    }

    public void setDepartLocation(String departLocation) {
        this.departLocation = departLocation;
    }
}
