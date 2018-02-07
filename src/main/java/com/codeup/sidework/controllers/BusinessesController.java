package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public BusinessesController(BusinessesRepository businessesRepository) {
        this.businessesRepository = businessesRepository;
    }

    @GetMapping("/users/register-mgmt")
    public String showManagementRegisterForm(Model model) {
        model.addAttribute("business", new Business());

        return "users/register-mgmt";
    }

    @PostMapping("/businesses/create")
    public String saveNewBusiness(@ModelAttribute Business business) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        business.setUser(businessesRepository.findOne(user.getId()));

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
