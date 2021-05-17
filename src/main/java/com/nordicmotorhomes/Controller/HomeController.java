package com.nordicmotorhomes.Controller;

import com.nordicmotorhomes.Service.CustomerService;
import com.nordicmotorhomes.Service.EmployeeService;
import com.nordicmotorhomes.Service.MotorhomeService;
import com.nordicmotorhomes.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MotorhomeService motorhomeService;
    @Autowired
    RentalService rentalService;

    public static void hentmig(){
    }

}
