package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.Listings;
import com.codeup.sidework.models.User;
import com.codeup.sidework.services.BusinessesService;
import com.codeup.sidework.services.ListingsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//1. Controller-->
@Controller
public class ListingsController {
    private ListingsService listingsService;
    private UserRepository usersDao;
    private BusinessesRepository businessDao;

    //2. Constructor-->
    public ListingsController(ListingsService listingsService, UserRepository usersDao, BusinessesRepository businessDao) {
        this.listingsService = listingsService;
        this.usersDao = usersDao;
        this.businessDao = businessDao;
    }



    //3. Logic to get a List of businesses by {id}
//    @GetMapping("listings/index{id}")
//    public String showWorkerProfile(@PathVariable long id, Model viewAndModel) { // Add a long id parameter
//        Listings listing = listingsService.findOne(id);
//        Worker worker = workerRepository.findByUser(user);
//        viewAndModel.addAttribute("user", user);
//        viewAndModel.addAttribute("worker", worker);
//        return "listings/index";
//    }


    //4. Logic to get a List of businesses-------------------->
    @GetMapping("/listings/index")
    public String showAllListings(Model model) {
        Iterable<Listings> listings = listingsService.findAll();
        model.addAttribute("listings", listings);

        return "listings/index";
    }














//    //5. Create Listings------------------->
//    @GetMapping("/listings/new")
//    public String showCreateNewListing(Model viewModel) {
//        viewModel.addAttribute("listing", new Listings());
//        return "listings/new";
//    }
//
//
//
//    //6. Display New Created Listings--------------->
//    @PostMapping("/listings/new")
//    public String saveListing(@ModelAttribute Listings listings) {
//
//        // In order for this line to always return a User you need to add this URL path
//        // to the SecurityConfiguration class
//        User owner = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        // If you ever find the "Detached entity error" the solution is to go for the user to
//        // the database using the repository -> usersRepository.findOne(owner.getId())
//        // instead of using the object directly
//        listings.setUser(usersDao.findOne(owner.getId()));
//        listings.setBusiness(businessDao.findOne(1L));
//        listingsService.save(listings);
//        return "redirect:/listings/index";
//    }









}