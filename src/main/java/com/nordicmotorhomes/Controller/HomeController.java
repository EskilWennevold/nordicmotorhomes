package com.nordicmotorhomes.Controller;

import com.nordicmotorhomes.Model.*;
import com.nordicmotorhomes.Service.CustomerService;
import com.nordicmotorhomes.Service.MotorhomeModelService;
import com.nordicmotorhomes.Service.MotorhomeService;
import com.nordicmotorhomes.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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
    //--------------------------------------------MOTORHOMES----------------------------------------------------
    //FOR SELECT MOTORHOME (CREATE AND UPDATE RENTAL)
    public Model getMotorhomes(Model model){
        return model.addAttribute("motorhomes",motorhomeService.loadAllMotorhomes());
    }
    public Model getMotorhomeById(Model model, int id){
        return model.addAttribute("motorhome",motorhomeService.viewMotorhome(id));
    }
    //MOTORHOME MENU
    @GetMapping("/motorhomeMenu")
    public String motorhomeMenu(Model model){
        model.addAttribute("motorhomes",motorhomeService.loadAllMotorhomes());
        return "/motorhomeMenu";
    }
    //CREATE MOTORHOME
    @GetMapping("/selectMotorhomemodel")
    public String selectMotorhomemodel(Model model){
        getModels(model);
        return "/selectMotorhomemodel";
    }
    @GetMapping("/createMotorhome/{modelid}")
    public String createMotorhome(@PathVariable("modelid") int id, Model model){
        model.addAttribute("motorhomemodel",motorhomeModelService.viewMotorhomeModel(id));
        return "/createMotorhome";
    }
    @PostMapping("/createMotorhome")
    public String createMotorhome(@ModelAttribute Motorhome m){
        motorhomeService.createMotorhome(m);
        return "redirect:/motorhomeMenu";
    }
    //VIEW MOTORHOME
    @GetMapping("/viewMotorhome/{motorhomeid}")
    public String viewMotorhome(@PathVariable("motorhomeid") int id, Model model){
        model.addAttribute("motorhome",motorhomeService.viewMotorhome(id));
        Motorhome m = motorhomeService.viewMotorhome(id);
        getModelById(model, m.getModelid());
        return "/viewMotorhome";
    }
    //UPDATE MOTORHOME
    @GetMapping("/updateMotorhome/{motorhomeid}")
    public String updateMotorhome(@PathVariable("motorhomeid") int id, Model model){
        model.addAttribute("motorhomeid", id);
        model.addAttribute("motorhome",motorhomeService.viewMotorhome(id));
        return "/updateMotorhome";
    }
    @GetMapping("/selectMotorhomemodelUpdate/{motorhomeid}")
    public String selectModelUpdate(@PathVariable("motorhomeid") int motorhomeid, Model model){
        model.addAttribute("motorhomeid", motorhomeid);
        getModels(model);
        return "/selectMotorhomemodelUpdate";
    }
    @GetMapping("/selectedUpdate/{motorhomeid}/{modelid}")
    public String selectedModelUpdate(@PathVariable("motorhomeid") int motorhomeid, @PathVariable("modelid") int id){
        motorhomeService.updateMotorhomesModel(motorhomeid, id);
        return "redirect:/updateMotorhome/"+motorhomeid;
    }
    @PostMapping("/updateMotorhome")
    public String updateMotorhomeM(@ModelAttribute Motorhome m){
        motorhomeService.updateMotorhome(m.getMotorhomeid(), m);
        return "redirect:/motorhomeMenu";
    }
    //DELETE MOTORHOME
    @GetMapping("/deleteMotorhome/{motorhomeid}")
    public String deleteMotorhome(@PathVariable("motorhomeid") int id){
        motorhomeService.deleteMotorhome(id);
        return "redirect:/motorhomeMenu";
    }

    //--------------------------------------------MOTORHOME-MODELS----------------------------------------------

    //FOR SELECT MOTORHOME (CREATE AND UPDATE MOTORHOME)
    public Model getModels(Model model){
        return model.addAttribute("motorhomeModels",motorhomeModelService.loadAllMotorhomeModels());
    }
    //FOR VIEW MOTORHOME
    public Model getModelById(Model model, int id){
        return model.addAttribute("motorhomemodel",motorhomeModelService.viewMotorhomeModel(id));
    }
    //MOTRORHOME-MODEL MENU
    @GetMapping("/modelMenu")
    public String motorhomemodelMenu(Model model){
        model.addAttribute("motorhomeModels",motorhomeModelService.loadAllMotorhomeModels());
        return"/modelMenu";
    }
    //CREATE MOTORHOME-MODEL
    @GetMapping("/createMotorhomemodel")
    public String createMotorhomemodel(){ return"/createMotorhomemodel"; }
    @PostMapping("/createMotorhomemodel")
    public String createMotorhomemodel(@ModelAttribute MotorhomeModel m){
        motorhomeModelService.createMotorhomeModel(m);
        return "redirect:/modelMenu";
    }
    //VIEW MOTORHOME-MODEL
    @GetMapping("/viewMotorhomemodel/{modelid}")
    public String viewMotorhomemodel(@PathVariable("modelid") int id, Model model){
        model.addAttribute("motorhomemodel",motorhomeModelService.viewMotorhomeModel(id));
        return "/viewMotorhomemodel";
    }
    //UPDATE MOTORHOME-MODEL
    @GetMapping("/updateMotorhomemodel/{modelid}")
    public String updateMotorhomemodel(@PathVariable("modelid") int id, Model model){
        model.addAttribute("motorhomemodel",motorhomeModelService.viewMotorhomeModel(id));
        return "/updateMotorhomemodel";
    }
    @PostMapping("/updateMotorhomemodel")
    public String updateMotorhomemodel(@ModelAttribute MotorhomeModel m){
        motorhomeModelService.updateMotorhomeModel(m.getModelid(), m);
        return "redirect:/modelMenu";
    }
    //DELETE MOTORHOME-MODEL
    @GetMapping("/deleteMotorhomemodel/{modelid}")
    public String deleteMotorhomemodel(@PathVariable("modelid") int id){
        motorhomeModelService.deleteMotorhomeModel(id);
            return "redirect:/modelMenu";
    }

    //--------------------------------------------CUSTOMERS----------------------------------------------

    //FOR SELECT CUSTOMER (CREATE AND UPDATE RENTAL)
    public Model getCustomers(Model model){
        return model.addAttribute("customers",customerService.loadAllCustomers());
    }
    public Model getCustomerById(Model model, int id){
        return model.addAttribute("customer",customerService.viewCustomer(id));
    }
    //CUSTOMER MENU
    @GetMapping("/customerMenu")
    public String customerMenu(Model model){
        model.addAttribute("customers",customerService.loadAllCustomers());
        return "/customerMenu";
    }
    //CREATE CUSTOMER
    @GetMapping("/createCustomer")
    public String createCustomer(){
        return "/createCustomer";
    }
    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer c){
        customerService.createCustomer(c);
        return "redirect:/customerMenu";
    }
    //VIEW CUSTOMER
    @GetMapping("/viewCustomer/{customerid}")
    public String viewCustomer(@PathVariable("customerid") int id, Model model){
        model.addAttribute("customer",customerService.viewCustomer(id));
        return "/viewCustomer";
    }
    //UPDATE CUSTOMER
    @GetMapping("/updateCustomer/{customerid}")
    public String updateCustomer(@PathVariable("customerid") int id, Model model){
        model.addAttribute("customer",customerService.viewCustomer(id));
        return "/updateCustomer";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer c){
        customerService.updateCustomer(c);
        return "redirect:/customerMenu";
    }
    //DELETE CUSTOMER
    @GetMapping("/deleteCustomer/{customerid}")
    public String deleteCustomer(@PathVariable("customerid") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customerMenu";
    }
    //--------------------------------------------RENTALS----------------------------------------------
    //RENTAL MENU
    @GetMapping("/rentalMenu")
    public String rentalMenu(Model model){
        model.addAttribute("rentals",rentalService.loadAllRentals());
        return "/rentalMenu";
    }
    //CREATE RENTAL
    @GetMapping("/selectCustomer")
    public String selectCustomer(Model model){
        getCustomers(model);
        return "/selectCustomer";
    }
    @GetMapping("/selectMotorhome/{customerid}")
    public String selectMotorhome(Model model,@PathVariable("customerid") int customerid){
        getMotorhomes(model);
        model.addAttribute("customerid",customerid);
        return "/selectMotorhome";
    }
    @GetMapping("/createRental/{customerid}/{motorhomeid}")
    public String createRental(@PathVariable("customerid") int customerid,@PathVariable("motorhomeid") int motorhomeid, Model model){
        model.addAttribute("customerid",customerid);
        model.addAttribute("motorhomeid",motorhomeid);
        return "/createRental";
    }
    @PostMapping("/createRental")
    public String createRental(@ModelAttribute Rental rental){
        rental.setPrice(calculatePrice(rental));
        rentalService.createRental(rental);
        return "redirect:/rentalMenu";
    }
    public int calculatePrice(Rental rental){
        int price = 0;
        int motorhomeid = rental.getMotorhomeid();
        Motorhome sm = motorhomeService.viewMotorhome(motorhomeid);
        int modelid = sm.getModelid();
        MotorhomeModel m = motorhomeModelService.viewMotorhomeModel(modelid);
        int days = rental.getDays();
        int pricePerDay = m.getPrice();
        int distance = rental.getDeliverydistance();
        int distancePrice = distance*5;
        price = days*pricePerDay+distancePrice;
        return price;
    }
    //VIEW RENTAL
    @GetMapping("/viewRental/{rentalid}")
    public String viewRental(@PathVariable("rentalid") int rentalid, Model model){
        Rental rental=rentalService.readRental(rentalid);
        model.addAttribute("rental",rental);
        getMotorhomeById(model, rental.getMotorhomeid());
        getCustomerById(model, rental.getCustomerid());
        Motorhome motorhome = motorhomeService.viewMotorhome(rental.getMotorhomeid());
        getModelById(model, motorhome.getModelid());
        return "/viewRental";
    }
    //UPDATE RENTAL
    @GetMapping("/updateRental/{rentalid}")
    public String updateRental(@PathVariable("rentalid") int id, Model model){
        Rental rental=rentalService.readRental(id);
        model.addAttribute("rental",rental);
        return "/updateRental";
    }
    /*
    @GetMapping("/selectCustomerUpdate/{rentalid}")
    public String selectCustomerUpdate(@PathVariable("rentalid") int rentalid, Model model){
        model.addAttribute("rentalid", rentalid);
        getCustomers(model);
        return "/selectCustomerUpdate";
    }
    @GetMapping("/selectMotorhomeUpdate/{rentalid}")
    public String selectMotorhomeUpdate(@PathVariable("rentalid") int rentalid, Model model){
        model.addAttribute("rentalid", rentalid);
        getMotorhomes(model);
        return "/selectMotorhomeUpdate";
    }
    @GetMapping("/selectedCustomerUpdate/{rentalid}")
    public String selectedCustomer(@ModelAttribute Customer c,@PathVariable("rentalid")int rentalid){
        rentalService.selectCustomer(rentalid,c.getCustomerid());
        return "redirect:/updateRental/"+rentalid;
    }
    @GetMapping("/selectedMotorhomeUpdate/{rentalid}")
    public String selectedMotorhome(@ModelAttribute Motorhome m,@PathVariable("rentalid")int rentalid){
        rentalService.selectMotorhome(rentalid,m.getMotorhomeid());
        return "redirect:/updateRental/"+rentalid;
    }
    */
    @PostMapping("/updateRental")
    public String updateRental(@ModelAttribute Rental rental){
        rental.setPrice(calculatePrice(rental));
        rentalService.updateRental(rental);
        return "redirect:/rentalMenu";
    }
    //DELETE RENTAL
    @GetMapping("/deleteRental/{rentalid}")
    public String deleteRental(@PathVariable("rentalid") int id){
        rentalService.deleteRental(id);
        return "redirect:/rentalMenu";
    }
}
