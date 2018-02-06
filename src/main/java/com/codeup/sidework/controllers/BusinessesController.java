package com.codeup.sidework.controllers;

import com.codeup.sidework.models.Business;
import com.codeup.sidework.daos.BusinessesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusinessesController {
    private final BusinessesRepository businessesRepository;

    public BusinessesController(BusinessesRepository businessesRepository) {
        this.businessesRepository = businessesRepository;
    }

    @GetMapping("/businesses/create")
    public String showCreateBusinessForm(Model model) {
        model.addAttribute("business", new Business());

        return "businesses/create";
    }

    @PostMapping("/businesses/create")
    public String saveNewBusiness(@ModelAttribute Business business) {
        businessesRepository.save(business);

        return "redirect:/users/login-mgmt";
    }

    @GetMapping("/users/workspace-mgmt")
    public String showManagmentWorkspace() {
        return "users/workspace-mgmt";
    }

    @GetMapping("/businesses/profile/{id}")
    public String viewBusinessProfile(@PathVariable long id, Model model) {
        // Pass a Business object to the template just for testing
        Business business = businessesRepository.findOne(id);

        model.addAttribute("business", business);

        return "businesses/profile";
    }
}
