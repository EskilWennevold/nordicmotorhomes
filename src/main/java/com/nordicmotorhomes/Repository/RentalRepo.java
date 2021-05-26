package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.Accessory;
import com.nordicmotorhomes.Model.Customer;
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
        String sql="SELECT * FROM rentals";
        RowMapper<Rental> rentalRowMapper = new BeanPropertyRowMapper<>(Rental.class);
        return jdbcTemplate.query(sql,rentalRowMapper);
    }
    public void createRental(Rental r){
        String rentalSql="INSERT INTO rentals (customerid,motorhomeid,deliveryaddress,startdate,enddate,price,deliverydistance,season) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(rentalSql,r.getCustomerid(),r.getMotorhomeid(),r.getDeliveryaddress(),r.getStartdate(),r.getEnddate(),r.getPrice(),r.getDeliverydistance(),r.getSeason());
        String rentalSql2="SELECT rentalid FROM rentals WHERE (customerid = ? AND motorhomeid = ? AND startdate = ?)";
        RowMapper<Rental> rentalRowMapper = new BeanPropertyRowMapper<>(Rental.class);
        int rentalid=jdbcTemplate.queryForObject(rentalSql2,rentalRowMapper,r.getCustomerid(),r.getMotorhomeid(),r.getStartdate()).getRentalid();
        for(Accessory a:r.getAccessories()){
            String accessorySql="INSERT INTO accessories_rentals (rentalid,accessoryid) VALUES (?,?)";
            RowMapper<Rental> accessoryRowMapper = new BeanPropertyRowMapper<>(Rental.class);
            jdbcTemplate.update(accessorySql,accessoryRowMapper,rentalid,a.getAccessoryid());
        }
    }
    public Rental readRental(int id){
        String rentalSql = "SELECT * FROM rentals WHERE rentalid = ?";
        RowMapper<Rental> rentalRowMapper = new BeanPropertyRowMapper<>(Rental.class);
        Rental rental = jdbcTemplate.queryForObject(rentalSql, rentalRowMapper, id);
        //String accesorySql = "SELECT * FROM accessories_rentals WHERE rentalid = ?";
        //RowMapper<Accessory> accessoryRowMapper = new BeanPropertyRowMapper<>(Accessory.class);
        //rental.setAccessories((ArrayList<Accessory>)jdbcTemplate.query(accesorySql, accessoryRowMapper));
        return rental;
    }
    public void updateRental(Rental r){
        String sql="UPDATE rentals SET customerid=?,motorhomeid=?,deliveryaddress=?,startdate=?,enddate=?,price=?,deliverydistance=?,season=? WHERE rentalid = ?";
        jdbcTemplate.update(sql,r.getCustomerid(),r.getMotorhomeid(),r.getDeliveryaddress(),r.getStartdate(),r.getEnddate(),r.getPrice(),r.getDeliverydistance(),r.getSeason(),r.getRentalid());
    }
    public void deleteRental(int id){
        String rentalSql="DELETE FROM rentals WHERE rentalid = ?";
        jdbcTemplate.update(rentalSql,id);
        String accessorySql="DELETE FROM accessories_rentals WHERE rentalid = ?";
        jdbcTemplate.update(accessorySql,id);
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
