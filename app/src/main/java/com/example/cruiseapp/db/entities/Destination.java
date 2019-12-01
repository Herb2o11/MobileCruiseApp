package com.example.cruiseapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "destination_table")
public class Destination {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "destination")
    String destination;

    public Destination(long id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
