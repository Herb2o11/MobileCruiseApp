package com.example.cruiseapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "state_room_table")
public class StateRoom {
  @PrimaryKey(autoGenerate = true)
  private long id;
  @ColumnInfo(name = "room_category")
    private String roomCategory;
    @ColumnInfo(name = "room_location")
    private String roomLocation;
    @ColumnInfo(name = "room_type")
    private String roomType;
    @ColumnInfo(name = "room_price")
    private double roomPrice;
    @ColumnInfo(name = "room_number")
    private int roomNumber;
    @ColumnInfo(name = "pic_id")
    private String picId;


    public StateRoom( String roomCategory,String roomType, String roomLocation , double roomPrice, int roomNumber, String picId) {

        this.roomCategory = roomCategory;
        this.roomLocation = roomLocation;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomNumber = roomNumber;
        this.picId = picId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }
}
