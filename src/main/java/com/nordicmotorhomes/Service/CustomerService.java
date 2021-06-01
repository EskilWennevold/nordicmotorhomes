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
    public void createCustomer(Customer c){ customerRepo.createCustomer(c); }
    public Customer viewCustomer(int id){ return customerRepo.viewCustomer(id); }
    public void updateCustomer(Customer c){ customerRepo.updateCustomer(c); }
    public void deleteCustomer(int id){
        customerRepo.deleteCustomer(id);
    }

}
