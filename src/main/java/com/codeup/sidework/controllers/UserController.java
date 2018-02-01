package com.codeup.sidework.controllers;

import com.codeup.sidework.models.User;
import com.codeup.sidework.repositories.Users;
import com.codeup.sidework.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    public UserController(Users users, UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users/register-mgmt")
    public String showManagementRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register-mgmt";
    }

    @PostMapping("/register")
    public String saveManagement(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/users/login-worker";
    }

    @GetMapping("/users/register-worker")
    public String showWorkerRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register-worker";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String saveWorker(@RequestParam(value = "optionsRadios") @ModelAttribute User user, String checkboxValue) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);

//        if (checkboxValue != null) {
            users.save(user);
            return "redirect:/users/login-worker";
//        }

//        return "users/register-worker";
    }
}