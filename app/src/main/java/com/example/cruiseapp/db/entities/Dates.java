package com.example.cruiseapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "dates_table")
public class Dates {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "month")
    String month;
    @ColumnInfo(name = "depart_options")
    String departOptions;

    public Dates(long id, String month, String departOptions) {
        this.id = id;
        this.month = month;
        this.departOptions = departOptions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDepartOptions() {
        return departOptions;
    }

    public void setDepartOptions(String departOptions) {
        this.departOptions = departOptions;
    }
}
