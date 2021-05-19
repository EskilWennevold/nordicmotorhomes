package com.nordicmotorhomes.Model;

public class Accessory {
    private int accessoryid;
    private String name;
    private int price;

    public Accessory(){}

    public int getAccessoryid() {
        return accessoryid;
    }

    public void setAccessoryid(int accessoryid) {
        this.accessoryid = accessoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
