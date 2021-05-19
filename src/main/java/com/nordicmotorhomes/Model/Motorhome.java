package com.nordicmotorhomes.Model;

public class Motorhome {
    private int motorhomeid;
    private int price;
    private String brand;
    private String model;
    private int beds;
    private int modelid;
    private int platenumber;

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

    public int getModelid() {
        return modelid;
    }

    public void setModelid(int modelid) {
        this.modelid = modelid;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(int platenumber) {
        this.platenumber = platenumber;
    }
}
