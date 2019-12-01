package com.example.cruiseapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "acomodation_travel_party_table")
public class AccomodationTravelParty {
    @PrimaryKey(autoGenerate = true)
    long id;
    @ColumnInfo(name="room_id")
    long roomId;
    @ColumnInfo(name="date_id")
    long dateId;
    @ColumnInfo(name = "destination_id")
    long destinationId;
    @ColumnInfo(name="user_id")
    long userId;
    @ColumnInfo(name="state_room_qtd")
    int stateroomQtd;
    @ColumnInfo(name="adults_qtd")
    int adultsQtd;
    @ColumnInfo(name="children_qtd")
    int childrenQtd;
    @ColumnInfo(name="children_age")
    int childrenAge;
    @ColumnInfo(name="acessible_room")
    boolean acessibleRoom;
    @ColumnInfo(name="children_price")
    String childrenPrice;
    boolean paid;


    public AccomodationTravelParty(long roomId, long dateId, long destinationId, long userId, int stateroomQtd, int adultsQtd, int childrenQtd, int childrenAge, boolean acessibleRoom, String childrenPrice, boolean paid) {
        this.roomId = roomId;
        this.dateId = dateId;
        this.destinationId = destinationId;
        this.userId = userId;
        this.stateroomQtd = stateroomQtd;
        this.adultsQtd = adultsQtd;
        this.childrenQtd = childrenQtd;
        this.childrenAge = childrenAge;
        this.acessibleRoom = acessibleRoom;
        this.childrenPrice = childrenPrice;
        this.paid = paid;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long dateId) {
        this.dateId = dateId;
    }

    public long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(long destinationId) {
        this.destinationId = destinationId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getStateroomQtd() {
        return stateroomQtd;
    }

    public void setStateroomQtd(int stateroomQtd) {
        this.stateroomQtd = stateroomQtd;
    }

    public int getAdultsQtd() {
        return adultsQtd;
    }

    public void setAdultsQtd(int adultsQtd) {
        this.adultsQtd = adultsQtd;
    }

    public int getChildrenQtd() {
        return childrenQtd;
    }

    public void setChildrenQtd(int childrenQtd) {
        this.childrenQtd = childrenQtd;
    }

    public int getChildrenAge() {
        return childrenAge;
    }

    public void setChildrenAge(int childrenAge) {
        this.childrenAge = childrenAge;
    }

    public boolean isAcessibleRoom() {
        return acessibleRoom;
    }

    public void setAcessibleRoom(boolean acessibleRoom) {
        this.acessibleRoom = acessibleRoom;
    }

    public String getChildrenPrice() {
        return childrenPrice;
    }

    public void setChildrenPrice(String childrenPrice) {
        this.childrenPrice = childrenPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}

