package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.User;
import com.codeup.sidework.services.ListingsService;
import com.codeup.sidework.daos.ListingsRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.Listing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

//  Controller
@Controller
public class ListingsController {
    private ListingsService listingsService;
    private BusinessesRepository businessDao;
    private final ListingsRepository listingsRepository;
    private final UserRepository userRepository;

    //  Constructor
    public ListingsController(ListingsService listingsService, BusinessesRepository businessDao,
                              ListingsRepository listingsRepository, UserRepository userRepository) {
        this.listingsService = listingsService;
        this.businessDao = businessDao;
        this.listingsRepository = listingsRepository;
        this.userRepository = userRepository;
    }

    //  Display the form to create a new listing
    @GetMapping("/listings/create")
    public String showCreateListingForm(Model model) {
        model.addAttribute("listing", new Listing());

        return "listings/create";
    }

    //  Save a new listing to the database
    @PostMapping("/listings/create")
    public String createNewListing(@ModelAttribute Listing listing) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Business business = businessDao.findByUser(user);
        listing.setBusiness(business);
        listingsRepository.save(listing);
        return "redirect:/businesses/profile/" + user.getId();
    }

    //  Logic to get a list of listings
    @GetMapping("/listings/index")
    public String showAllListings(Model model) {
        Iterable<Listing> listings = listingsService.findAll();
        model.addAttribute("listings", listings);

        return "listings/index";
    }

    //  Display a single listing
    @GetMapping("/listings/single/{id}")
    public String viewSingleListing(@PathVariable long id, Model model, User user) {
        Listing listing = listingsRepository.findOne(id);
        user = userRepository.findOne(user.getId());
        Business business = businessDao.findByUser(user);

        model.addAttribute("listing", listing);
        model.addAttribute("user", user);
        model.addAttribute("business", business);

        return "listings/single";
    }

    @GetMapping("/listings/{id}/edit")
    public String showEditListingForm(@PathVariable long id, Model model) {
        Listing listing = listingsRepository.findOne(id);

        model.addAttribute("listing", listing);

        return "listings/edit";
    }

    @PostMapping("listings/{id}/edit")
    public String editListing(@PathVariable long id, @ModelAttribute Listing listing,
                              @ModelAttribute Business business) {
        listing.setBusiness(business);
        listing.setId(id);
        listingsRepository.save(listing);

        return "redirect:/listings/single" + id;
    }
}
