package com.nordicmotorhomes.Model;

public class Motorhome {
    private int motorhomeid;
    private int price;
    private String brand;
    private String model;
    private int bed;

    public Motorhome(){}

    public int getMotorhomeid() {
        return motorhomeid;
    }

    public void setMotorhomeid(int motorhomeid) {
        this.motorhomeid = motorhomeid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
}
