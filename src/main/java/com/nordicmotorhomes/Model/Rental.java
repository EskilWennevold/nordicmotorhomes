package com.nordicmotorhomes.Model;

import java.util.ArrayList;

public class Rental {
    private int rentalid;
    private int customerid;
    private int motorhomeid;
    private String deliveryaddress;
    private String startdate;
    private String enddate;
    private int price;
    private int deliverydistance;
    private String season;
    private ArrayList <Accessory> accessories = new ArrayList<>();

    public Rental(){}

    public int getRentalid() {
        return rentalid;
    }

    public void setRentalid(int rentalid) {
        this.rentalid = rentalid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getMotorhomeid() {
        return motorhomeid;
    }

    public void setMotorhomeid(int motorhomeid) {
        this.motorhomeid = motorhomeid;
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDeliverydistance() {
        return deliverydistance;
    }

    public void setDeliverydistance(int deliverydistance) {
        this.deliverydistance = deliverydistance;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public ArrayList<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<Accessory> accessories) {
        this.accessories = accessories;
    }
}
