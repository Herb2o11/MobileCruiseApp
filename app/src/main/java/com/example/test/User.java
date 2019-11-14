package com.example.test;


//class created to make it more confortable to pass data through classes
public class User {
    String Email;
    String Password;
    String PasswordConfirmation;
    String Name;
    long Phone;
    String Address;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPasswordConfirmation() {
        return PasswordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        PasswordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getPhone() {
        return Phone;
    }

    public void setPhone(long phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


}
