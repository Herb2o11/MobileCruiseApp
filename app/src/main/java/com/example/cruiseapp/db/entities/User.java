package com.example.cruiseapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String email;
    private String password;
    @ColumnInfo(name = "password_confirmation")
    private String passwordConfirmation;
    private String name;
    @ColumnInfo(name = "travel_party_id")
    private long travelPartyId;
    private String phone;
    private String address;

    @Ignore
    public User() {

    }
    public User(long id, String email, String password, String passwordConfirmation, String name, String phone, String address, long travelPartyId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.travelPartyId = travelPartyId;
    }

    public long getTravelPartyId() {
        return travelPartyId;
    }

    public void setTravelPartyId(long travelPartyId) {
        this.travelPartyId = travelPartyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
