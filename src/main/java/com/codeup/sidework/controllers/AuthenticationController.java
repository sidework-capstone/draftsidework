package com.codeup.sidework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/users/login-mgmt")
    public String showManagementLoginForm() {
        return "users/login-mgmt";
    }

    @GetMapping("/users/login-worker")
    public String showWorkerLoginForm() {
        return "users/login-worker";
    }
}
