package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.Accessory;
import com.nordicmotorhomes.Model.Motorhome;
import com.nordicmotorhomes.Model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        String rentalSql = "SELECT * FROM rentals WHERE rentalid = ?";
        RowMapper<Rental> rentalRowMapper = new BeanPropertyRowMapper<>(Rental.class);
        Rental rental = jdbcTemplate.queryForObject(rentalSql, rentalRowMapper, rentalid);
        String accesorySql = "SELECT * FROM accessories_rentals WHERE rentalid = ?";
        RowMapper<Accessory> accessoryRowMapper = new BeanPropertyRowMapper<>(Accessory.class);
        rental.setAccessories((ArrayList<Accessory>)jdbcTemplate.query(accesorySql, accessoryRowMapper));
        return rental;
    }
    public void updateRental(int rentalid,Rental rental){

    }
    public void deleteRental(int rentalid){

    }
}
