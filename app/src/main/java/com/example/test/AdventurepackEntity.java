package com.example.test;

public class AdventurepackEntity {

    private int advImage ;
    private String name , description;
    private double advPrice;

    public AdventurepackEntity(int advImage, String name, String description, double advPrice) {

        this.advImage = advImage;
        this.name = name;
        this.description = description;
        this.advPrice = advPrice;
    }

    public int getAdvImage() {
        return advImage;
    }

    public void setAdvImage(int advImage)
    { this.advImage = advImage; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAdvPrice() {
        return advPrice;
    }

    public void setAdvPrice(double advPrice) {
        this.advPrice = advPrice;
    }
}


