package com.nordicmotorhomes.Repository;

import com.nordicmotorhomes.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Customer> loadAllCustomers(){
        return null;
    }
    public void createCustomer(Customer customer){

    }
    public Customer readCustomer(int customerid){
        return null;
    }
    public void updateCustomer(int customerid,Customer customer){

    }
    public void deleteCustomer(int customerid){

    }
}
