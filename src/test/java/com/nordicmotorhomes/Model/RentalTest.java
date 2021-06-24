package com.nordicmotorhomes.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @Test
    void getRentalid() {
        Rental r = new Rental();
        r.setRentalid(6);

        assertEquals(6,r.getRentalid());
    }

    @Test
    void getCustomerid() {
        Rental r = new Rental();
        r.setCustomerid(6);

        assertEquals(6,r.getCustomerid());

    }

    @Test
    void getMotorhomeid() {
        Rental r = new Rental();
        r.setMotorhomeid(6);

        assertEquals(6,r.getMotorhomeid());
    }

    @Test
    void getDeliveryaddress() {
        Rental r = new Rental();
        r.setDeliveryaddress("Heimdalsvej 39a");

        assertEquals("Heimdalsvej 39a",r.getDeliveryaddress());
    }

    @Test
    void getStartdate() {
        Rental r = new Rental();
        r.setStartdate("2020-01-01");

        assertEquals("2020-01-01",r.getStartdate());
    }

    @Test
    void getEnddate() {
        Rental r = new Rental();
        r.setEnddate("2020-02-01");

        assertEquals("2020-02-01",r.getEnddate());
    }

    @Test
    void getPrice() {
        Rental r = new Rental();
        r.setPrice(6);

        assertEquals(6,r.getPrice());
    }

    @Test
    void getDeliverydistance() {
        Rental r = new Rental();
        r.setDeliverydistance(87);

        assertEquals(87,r.getDeliverydistance());
    }

    @Test
    void getSeason() {
        Rental r = new Rental();
        r.setSeason("Høj");

        assertEquals("Høj",r.getSeason());
    }

    @Test
    void getDays() {
        Rental r = new Rental();
        r.setDays(7);

        assertEquals(7,r.getDays());
    }
}