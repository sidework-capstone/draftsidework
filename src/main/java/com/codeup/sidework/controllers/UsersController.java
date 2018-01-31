package com.codeup.sidework.controllers;

import com.codeup.sidework.models.User;
import com.codeup.sidework.repositories.Users;
import com.codeup.sidework.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class UsersController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register-mgmt.html";
    }
}
