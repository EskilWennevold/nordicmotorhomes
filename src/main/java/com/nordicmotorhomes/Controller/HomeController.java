package com.nordicmotorhomes.Controller;

import com.nordicmotorhomes.Model.MotorhomeModel;
import com.nordicmotorhomes.Service.CustomerService;
import com.nordicmotorhomes.Service.MotorhomeModelService;
import com.nordicmotorhomes.Service.MotorhomeService;
import com.nordicmotorhomes.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController{
    @Autowired
    CustomerService customerService;
    @Autowired
    MotorhomeService motorhomeService;
    @Autowired
    RentalService rentalService;
    @Autowired
    MotorhomeModelService motorhomeModelService;

    @GetMapping("/")
    public String mainMenu(){ return "/mainMenu"; }

    @GetMapping("/motorhomeMenu")
    public String motorhomeMenu(Model model){
        model.addAttribute("motorhomes",motorhomeService.loadAllMotorhomes());
        return "/motorhomeMenu";
    }

    @GetMapping("/customerMenu")
    public String customerMenu(Model model){
        model.addAttribute("customers",customerService.loadAllCustomers());
        return "/customerMenu";
    }

    @GetMapping("/rentalMenu")
    public String rentalMenu(Model model){
        model.addAttribute("rentals",rentalService.loadAllRentals());
        return "/rentalMenu";
    }
    @GetMapping("/modelMenu")
    public String modelMenu(Model model){
        model.addAttribute("motorhomeModels",motorhomeModelService.loadAllMotorhomeModels());
        return"/modelMenu";
    }
    @GetMapping("/createMotorhomemodel")
    public String createMotorhomemodel(){ return"/createMotorhomemodel"; }

    @PostMapping("/createMotorhomemodel")
    public String createMotorhomemodel(@ModelAttribute MotorhomeModel motorhomeModel){
        motorhomeModelService.createMotorhomeModel(motorhomeModel);
        return "redirect:/modelMenu";
    }

}
