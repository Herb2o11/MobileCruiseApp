package com.example.test;

public class AccomodationTravelPartyEntity {

    String roomId;
    String dateId;
    String destinationId;
    String UserId;
    int stateroomQtd;
    int adultsQtd;
    int childrenQtd;
    int childrenAge;
    boolean acessibleRoom;
    String childrenPrice;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
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
}

