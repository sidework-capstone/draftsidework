package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.daos.ListingsRepository;
import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.Listing;
import com.codeup.sidework.models.User;
import com.codeup.sidework.services.BusinessesService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BusinessesController {
    private final BusinessesRepository businessesRepository;
    private final UserRepository userRepository;
    private final ListingsRepository listingsRepository;
    private final PasswordEncoder passwordEncoder;
    private BusinessesService businessesService;

    public BusinessesController(
            BusinessesRepository businessesRepository,
            UserRepository userRepository,
            ListingsRepository listingsRepository, PasswordEncoder passwordEncoder,
            BusinessesService businessesService
    ) {
        this.businessesRepository = businessesRepository;
        this.userRepository = userRepository;
        this.listingsRepository = listingsRepository;
        this.passwordEncoder = passwordEncoder;
        this.businessesService = businessesService;
    }


    @GetMapping("/businesses/create")
    public String showCreateBusinessForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("business", new Business());

        return "businesses/create";
    }

    @PostMapping("/businesses/create")
    public String saveNewBusiness(@ModelAttribute User user, @ModelAttribute Business business) {
        String hash = passwordEncoder.encode(user.getPassword());

        user.setPassword(hash);
        userRepository.save(user);
        business.setUser(user);
        user.setBusiness(business);
        businessesRepository.save(business);

        return "redirect:/login";
    }

    @GetMapping("/businesses")
    public String showAllBusinesses(Model model) {
        Iterable<Business> businesses = businessesService.findAll();

        model.addAttribute("businesses", businesses);

        return "businesses/index";
    }

    @GetMapping("/businesses/profile/{id}")
    public String viewBusinessProfile(@PathVariable long id, Model model) {
        User user = userRepository.findOne(id);
        Business business = businessesRepository.findByUser(user);
        List<Listing> listings = listingsRepository.findAllByBusiness(business);
        model.addAttribute("user", user);
        model.addAttribute("business", business);
        model.addAttribute("listings", listings);

        return "businesses/profile";
    }

    @GetMapping("/businesses/index")
    public String viewAllBusinesses(Model model) {
        Iterable<Business> businesses = businessesRepository.findAll();

        model.addAttribute("businesses", businesses);

        return "businesses/index";
    }

    @GetMapping("/businesses/edit/{id}")
    public String showEditBusinessForm(@PathVariable long id, Model model) {
        User user = userRepository.findOne(id);
        Business business = businessesRepository.findByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("business", business);

        return "businesses/edit";
    }

    @PostMapping("/businesses/edit/{id}")
    public String editBusiness(@ModelAttribute User user,
                               @ModelAttribute Business business,
                               @PathVariable long id) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        business.setUser(user);
        business.setId(id);
        businessesRepository.save(business);

        return "redirect:/businesses/profile/" + id;
    }
}
