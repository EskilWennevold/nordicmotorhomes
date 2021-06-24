package com.nordicmotorhomes.Controller;

import com.nordicmotorhomes.Model.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
    void calculatePrice() {
        Rental r = new Rental();
        r.setDays(7);
        r.setDeliverydistance(70);
        r.setMotorhomeid(1);

        HomeController h = new HomeController();

        r.setPrice(h.calculatePrice(r));

        assertEquals(0 ,r.getPrice());
    }
}