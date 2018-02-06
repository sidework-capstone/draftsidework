package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessesController {
    private UserRepository userRepository;
    private final BusinessesRepository businessesRepository;
    private PasswordEncoder passwordEncoder;

    public BusinessesController(BusinessesRepository businessesRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.businessesRepository = businessesRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping("/users/register-mgmt")
    public String showManagementRegisterForm(Model model) {
        model.addAttribute("business", new Business());
        model.addAttribute("user", new User());
        return "users/register-mgmt";
    }

    @PostMapping("/users/register-mgmt")
    public String saveManagementBusiness(@ModelAttribute User user, @ModelAttribute Business business) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
        business.setUser(user);
        businessesRepository.save(business);
        return "redirect:/login";
    }

    @GetMapping("/users/workspace-mgmt")
    public String showManagmentWorkspace() {

        return "users/workspace-mgmt";
    }

    @GetMapping("/users/profile-business")
    public String viewBusinessProfile() {
        return "users/profile-business";
    }
}
