package com.codeup.sidework.controllers;

import com.codeup.sidework.models.Business;
import com.codeup.sidework.repositories.Businesses;
import com.codeup.sidework.repositories.BusinessesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessController {
    private Businesses businesses;
    private PasswordEncoder passwordEncoder;
    private final BusinessesRepository businessesRepository;

    public BusinessController(Businesses businesses, PasswordEncoder passwordEncoder,
                              BusinessesRepository businessesRepository) {
        this.businesses = businesses;
        this.passwordEncoder = passwordEncoder;
        this.businessesRepository = businessesRepository;
    }

    @GetMapping("/users/register-mgmt")
    public String showManagementRegisterForm(Model model) {
        model.addAttribute("business", new Business());
        return "users/register-mgmt";
    }

    @PostMapping("/register")
    public String saveManagement(@ModelAttribute Business business) {
        String hash = passwordEncoder.encode(business.getPassword());
        business.setPassword(hash);
        businesses.save(business);
        return "redirect:/users/login-mgmt";
    }

    @GetMapping("/users/workspace-mgmt")
    public String showManagementWorkspace() {
        return "users/workspace-mgmt";
    }
}
