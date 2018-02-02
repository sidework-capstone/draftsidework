package com.codeup.sidework.controllers;

import com.codeup.sidework.models.Business;
import com.codeup.sidework.repositories.Businesses;
import com.codeup.sidework.repositories.BusinessesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessController {
    private Businesses businesses;
    private final BusinessesRepository businessesRepository;

    public BusinessController(Businesses businesses, BusinessesRepository businessesRepository) {
        this.businesses = businesses;
        this.businessesRepository = businessesRepository;
    }

    @PostMapping("/registerbusiness")
    public void saveNewBusiness(@ModelAttribute Business business) {
        businesses.save(business);
    }
}
