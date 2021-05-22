package com.nordicmotorhomes.Service;

import com.nordicmotorhomes.Model.Customer;
import com.nordicmotorhomes.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> loadAllCustomers(){ return customerRepo.loadAllCustomers(); }

    public void createCustomer(Customer customer){ customerRepo.createCustomer(customer); }

    public Customer readCustomer(int id){ return customerRepo.selectCustomer(id); }

    public void updateCustomer(int id,Customer customer){ customerRepo.updateCustomer(customer); }

    public void deleteCustomer(int id){
        customerRepo.deleteCustomer(id);
    }

}
