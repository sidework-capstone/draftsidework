package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.ListingsRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.Listing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListingsController {
    private final ListingsRepository listingsRepository;

    public ListingsController(ListingsRepository listingsRepository) {
        this.listingsRepository = listingsRepository;
    }

    @GetMapping("/listings/create")
    public String showCreateListingForm(Model model) {
        model.addAttribute("listing", new Listing());

        return "listings/create";
    }

    @PostMapping("/listings/create")
    public String createNewListing(@ModelAttribute Business business, @ModelAttribute Listing listing) {
        listingsRepository.save(listing);
        return "redirect:/businesses/profile/" + business.getId();
    }
}
