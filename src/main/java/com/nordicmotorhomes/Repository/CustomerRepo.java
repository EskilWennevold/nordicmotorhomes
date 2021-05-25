package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.Customer;
import com.nordicmotorhomes.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Customer> loadAllCustomers(){
        String sql="SELECT * FROM customers";
        RowMapper<Customer> rowMapper=new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
    public void createCustomer(Customer c){
        //String citySql="INSERT INTO cities (zip,city) VALUES (?,?) WHERE NOT EXIST (SELECT * FROM cities WHERE zip=? AND city=?)";
        //jdbcTemplate.update(citySql,c.getZip(),c.getCity(),c.getZip(),c.getCity());
        String customerSql="INSERT INTO customers (firstname,lastname,phonenumber,address,zip,email) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(customerSql,c.getFirstname(),c.getLastname(),c.getPhonenumber(),c.getAddress(),c.getZip(),c.getEmail());
    }
    public Customer selectCustomer(int id){
        String sql="SELECT * FROM customers JOIN cities USING(zip) WHERE customerid = ?";
        RowMapper<Customer> rowMapper=new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
    public void updateCustomer(Customer c){
        String sql="UPDATE customers SET firstname=?,lastname=?,phonenumber=?,address=?,zip=?,email=? WHERE customerid = ?";
        jdbcTemplate.update(sql,c.getFirstname(),c.getLastname(),c.getPhonenumber(),c.getAddress(),c.getZip(),c.getEmail(),c.getCustomerid());
    }
    public void deleteCustomer(int id){
        String sql="DELETE FROM customers WHERE customerid = ?";
        jdbcTemplate.update(sql,id);
    }
}
