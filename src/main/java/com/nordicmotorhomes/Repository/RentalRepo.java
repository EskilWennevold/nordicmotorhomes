package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Rental> loadAllRentals(){
        String sql="SELECT * FROM rentals";
        RowMapper<Rental> rentalRowMapper = new BeanPropertyRowMapper<>(Rental.class);
        return jdbcTemplate.query(sql,rentalRowMapper);
    }
    public void createRental(Rental r){
        String rentalSql="INSERT INTO rentals (customerid,motorhomeid,deliveryaddress,startdate,enddate,price,deliverydistance,season) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(rentalSql,r.getCustomerid(),r.getMotorhomeid(),r.getDeliveryaddress(),r.getStartdate(),r.getEnddate(),r.getPrice(),r.getDeliverydistance(),r.getSeason());
    }
    public Rental readRental(int id){
        String rentalSql = "SELECT * FROM rentals WHERE rentalid = ?";
        RowMapper<Rental> rentalRowMapper = new BeanPropertyRowMapper<>(Rental.class);
        Rental rental = jdbcTemplate.queryForObject(rentalSql, rentalRowMapper, id);
        return rental;
    }
    public void updateRental(Rental r){
        String sql="UPDATE rentals SET customerid=?,motorhomeid=?,deliveryaddress=?,startdate=?,enddate=?,price=?,deliverydistance=?,season=? WHERE rentalid = ?";
        jdbcTemplate.update(sql,r.getCustomerid(),r.getMotorhomeid(),r.getDeliveryaddress(),r.getStartdate(),r.getEnddate(),r.getPrice(),r.getDeliverydistance(),r.getSeason(),r.getRentalid());
    }
    public void deleteRental(int id){
        String rentalSql="DELETE FROM rentals WHERE rentalid = ?";
        jdbcTemplate.update(rentalSql,id);
    }
    public void selectCustomer(int rentalid,int customerid){
        String sql="UPDATE rentals SET customerid=? WHERE rentalid = ?";
        jdbcTemplate.update(sql,customerid,rentalid);
    }
    public void selectMotorhome(int rentalid,int motorhomeid){
        String sql="UPDATE rentals SET motorhomeid=? WHERE rentalid = ?";
        jdbcTemplate.update(sql,motorhomeid,rentalid);
    }
}
