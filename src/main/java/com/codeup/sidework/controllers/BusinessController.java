package com.codeup.sidework.controllers;

import com.codeup.sidework.repositories.Businesses;
import com.codeup.sidework.repositories.BusinessesRepository;
import org.springframework.stereotype.Controller;

@Controller
public class BusinessController {
    private Businesses businesses;
    private final BusinessesRepository businessesRepository;

    public BusinessController(Businesses businesses, BusinessesRepository businessesRepository) {
        this.businesses = businesses;
        this.businessesRepository = businessesRepository;
    }

//    @PostMapping("/register")
//    public String saveNewBusiness(@ModelAttribute Business business) {
//        businesses.save(business);
//        return "redirect:/users/login-mgmt";
//    }
}
