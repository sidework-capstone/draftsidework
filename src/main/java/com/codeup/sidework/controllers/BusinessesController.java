package com.codeup.sidework.controllers;

import com.codeup.sidework.models.Business;
import com.codeup.sidework.daos.BusinessesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessesController {
    private final BusinessesRepository businessesDao;
    private PasswordEncoder passwordEncoder;

    public BusinessesController(BusinessesRepository businessesDao, PasswordEncoder passwordEncoder) {
        this.businessesDao = businessesDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users/register-mgmt")
    public String showManagementRegisterForm(Model model) {
        model.addAttribute("business", new Business());
        return "users/register-mgmt";
    }

    @PostMapping("/users/register-mgmt")
    public String saveManagementBusiness(@ModelAttribute Business business) {
        String hash = passwordEncoder.encode(business.getPassword());
        business.setPassword(hash);
        businessesDao.save(business);
        return "redirect:/users/login-mgmt";
    }


//    @PostMapping("/register")
//    public String saveNewBusiness(@ModelAttribute Business business) {
//        businesses.save(business);
//        return "redirect:/users/login-mgmt";
//    }
}
