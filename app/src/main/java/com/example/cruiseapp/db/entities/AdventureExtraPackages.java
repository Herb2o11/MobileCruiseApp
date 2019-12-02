package com.example.cruiseapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "adventure_extra_packages")
public class AdventureExtraPackages {

    @PrimaryKey(autoGenerate = false)
    private long id;

    @ColumnInfo(name = "activity_name")
    String activityName;

    @ColumnInfo(name = "activity_price")
    String activityPrice;

    public AdventureExtraPackages(long id, String activityName, String activityPrice) {
        this.id = id;
        this.activityName = activityName;
        this.activityPrice = activityPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(String activityPrice) {
        this.activityPrice = activityPrice;
    }
}
