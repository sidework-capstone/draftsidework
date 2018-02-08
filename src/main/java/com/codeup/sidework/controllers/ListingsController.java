package com.codeup.sidework.controllers;

import com.codeup.sidework.models.Listings;
import com.codeup.sidework.services.ListingsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//1. Controller-->
@Controller
public class ListingsController {
    private ListingsService listingsService;

    //2. Constructor-->
    public ListingsController(ListingsService listingsService) {
        this.listingsService = listingsService;
    }


    //3. Get Mapping-->
    @GetMapping("/business/listings")
    public String showAllListings(Model model) {
        Iterable<Listings> listings = listingsService.findAll();

        model.addAttribute("listings", listings);

        return "businesses/listings";
    }

}
