package com.example.test;

public class StateRoomDbEntity {

    int roomId;
    String roomCategory;
    String roomLocation;
    String roomType;
    Float room_Price;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public Float getRoom_Price() {
        return room_Price;
    }

    public void setRoom_Price(Float room_Price) {
        this.room_Price = room_Price;
    }
}
