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

    public Customer createCustomer(Customer customer){ return customerRepo.createCustomer(customer); }

    public Customer readCustomer(int id){ return customerRepo.readCustomer(id); }

    public Customer updateCustomer(int id,Customer customer){ return customerRepo.updateCustomer(id,customer); }

    public boolean deleteCustomer(int id){
        return customerRepo.deleteCustomer(id);
    }

}
