package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Rental> loadAllRentals(){
        return null;
    }
    public void createRental(Rental rental){

    }
    public Rental readRental(int rentalid){
        return null;
    }
    public void updateRental(int rentalid,Rental rental){

    }
    public void deleteRental(int rentalid){

    }
}
