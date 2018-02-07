package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.BusinessesRepository;
import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    public BusinessesController(
            BusinessesRepository businessesRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.businessesRepository = businessesRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

        businessesRepository.save(business);

        return "redirect:/login";
    }

    @GetMapping("/users/workspace-mgmt")
    public String showManagmentWorkspace() {
        return "users/workspace-mgmt";
    }

    @GetMapping("/businesses/profile/{id}")
    public String viewBusinessProfile(@PathVariable long id, Model model) {
        User user = userRepository.findOne(id);
        Business business = businessesRepository.findByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("business", business);

        return "businesses/profile";
    }
}
