package com.nordicmotorhomes.Model;

public class Motorhome {
    private int motorhomeid;
    private int modelid;
    private int platenumber;

    public Motorhome(){}

    public int getMotorhomeid() {
        return motorhomeid;
    }

    public void setMotorhomeid(int motorhomeid) {
        this.motorhomeid = motorhomeid;
    }

    public int getModelid() { return modelid; }

    public void setModelid(int modelid) { this.modelid = modelid; }

    public int getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(int platenumber) {
        this.platenumber = platenumber;
    }
}
