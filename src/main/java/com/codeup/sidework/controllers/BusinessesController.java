package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessesController {
    private final BusinessesRepository businessesRepository;
    private final UserRepository userRepository;

    public BusinessesController(BusinessesRepository businessesRepository, UserRepository userRepository) {
        this.businessesRepository = businessesRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/businesses/create")
    public String showCreateBusinessForm(Model model) {
        model.addAttribute("business", new Business());

        return "businesses/create";
    }

    @PostMapping("/businesses/create")
    public String saveNewBusiness(@ModelAttribute Business business) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        business.setUser(userRepository.findOne(user.getId()));

        businessesRepository.save(business);

        return "redirect:/businesses/create";
    }

    @GetMapping("/users/workspace-mgmt")
    public String showManagmentWorkspace() {
        return "users/workspace-mgmt";
    }

    @GetMapping("/businesses/profile/{id}")
    public String viewBusinessProfile(@PathVariable long id, Model model) {
        Business business = businessesRepository.findOne(id);

        model.addAttribute("business", business);

        return "businesses/profile";
    }
}
