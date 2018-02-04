package com.codeup.sidework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/users/login-worker")
    public String showWorkerLoginForm() {
        return "users/login-worker";
    }

    @GetMapping("/users/login-mgmt")
    public String showManagementLoginForm() {
        return "users/login-mgmt";
    }
}













//package com.codeup.sidework.controllers;
//
//import com.codeup.sidework.daos.BusinessesRepository;
//import com.codeup.sidework.daos.UserRepository;
//import com.codeup.sidework.models.Business;
//import com.codeup.sidework.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class AuthenticationController {
//    private final UserRepository userRepository;
//    private final BusinessesRepository businessesRepository;
//
//
//    public AuthenticationController(UserRepository userRepository, BusinessesRepository businessesRepository) {
//        this.userRepository = userRepository;
//        this.businessesRepository = businessesRepository;
//    }
//
//    @GetMapping("/users/login-worker")
//    public String showWorkerLoginForm(Model model) {
//
//        model.addAttribute("user", new User());
//        return "users/login-worker";
//    }
//
//
//
//    @GetMapping("/users/login-mgmt")
//    public String showManagementLoginForm(Model model) {
//
//        model.addAttribute("business", new Business());
//        return "users/login-mgmt";
//    }
//}
