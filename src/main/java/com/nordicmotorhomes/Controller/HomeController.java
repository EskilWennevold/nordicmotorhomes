package com.nordicmotorhomes.Controller;

import com.nordicmotorhomes.Model.Customer;
import com.nordicmotorhomes.Model.Motorhome;
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
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/rentalMenu")
    public String rentalMenu(Model model){
        model.addAttribute("rentals",rentalService.loadAllRentals());
        return "/rentalMenu";
    }
    //--------------------------------------------Motorhomes----------------------------------------------------
    @GetMapping("/motorhomeMenu")
    public String motorhomeMenu(Model model){
        model.addAttribute("motorhomes",motorhomeService.loadAllMotorhomes());
        return "/motorhomeMenu";
    }
    @GetMapping("/selectMotorhomemodel")
    public String selectMotorhomemodel(Model model){
        //model.addAttribute("motorhomeModels",motorhomeModelService.loadAllMotorhomeModels());
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
    @GetMapping("/viewMotorhome/{motorhomeid}")
    public String viewMotorhome(@PathVariable("motorhomeid") int id, Model model){
        model.addAttribute("motorhome",motorhomeService.viewMotorhome(id));
        Motorhome m = motorhomeService.viewMotorhome(id);
        getModelById(model, m.getModelid());
        return "/viewMotorhome";
    }







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
    @GetMapping("/deleteMotorhome/{motorhomeid}")
    public String deleteMotorhome(@PathVariable("motorhomeid") int id){
        motorhomeService.deleteMotorhome(id);
        return "redirect:/motorhomeMenu";
    }
    //--------------------------------------------Motorhome Models----------------------------------------------
    public Model getModels(Model model){
        return model.addAttribute("motorhomeModels",motorhomeModelService.loadAllMotorhomeModels());
    }
    public Model getModelById(Model model, int id){
        return model.addAttribute("motorhomemodel",motorhomeModelService.viewMotorhomeModel(id));
    }
    @GetMapping("/modelMenu")
    public String motorhomemodelMenu(Model model){
        model.addAttribute("motorhomeModels",motorhomeModelService.loadAllMotorhomeModels());
        return"/modelMenu";
    }
    @GetMapping("/createMotorhomemodel")
    public String createMotorhomemodel(){ return"/createMotorhomemodel"; }
    @PostMapping("/createMotorhomemodel")
    public String createMotorhomemodel(@ModelAttribute MotorhomeModel m){
        motorhomeModelService.createMotorhomeModel(m);
        return "redirect:/modelMenu";
    }
    @GetMapping("/viewMotorhomemodel/{modelid}")
    public String viewMotorhomemodel(@PathVariable("modelid") int id, Model model){
        model.addAttribute("motorhomemodel",motorhomeModelService.viewMotorhomeModel(id));
        return "/viewMotorhomemodel";
    }
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
    @GetMapping("/deleteMotorhomemodel/{modelid}")
    public String deleteMotorhomemodel(@PathVariable("modelid") int id){
        motorhomeModelService.deleteMotorhomeModel(id);
            return "redirect:/modelMenu";
    }
    //--------------------------------------------Customers----------------------------------------------
    @GetMapping("/customerMenu")
    public String customerMenu(Model model){
        model.addAttribute("customers",customerService.loadAllCustomers());
        return "/customerMenu";
    }

    @GetMapping("/createCustomer")
    public String createCustomer(){
        return "/createCustomer";
    }
    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer c){
        customerService.createCustomer(c);
        return "redirect:/customerMenu";
    }

    @GetMapping("/viewCustomer/{customerid}")
    public String viewCustomer(@PathVariable("customerid") int id, Model model){
        model.addAttribute("customer",customerService.readCustomer(id));
        return "/viewCustomer";
    }

    @GetMapping("/updateCustomer/{customerid}")
    public String updateCustomer(@PathVariable("customerid") int id, Model model){
        model.addAttribute("customer",customerService.readCustomer(id));
        return "/updateCustomer";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer c){
        customerService.updateCustomer(c);
        return "redirect:/customerMenu";
    }
    @GetMapping("/deleteCustomer/{customerid}")
    public String deleteCustomer(@PathVariable("customerid") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customerMenu";
    }
}
