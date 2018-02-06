package com.codeup.sidework.controllers;


import com.codeup.sidework.daos.WorkerRepository;
import com.codeup.sidework.models.User;
import com.codeup.sidework.models.Worker;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private WorkerRepository workerRepository;

    public HomeController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Worker worker = workerRepository.findByUser(user);
        if (worker != null) {
            return "redirect:/users/profile-worker";
        }

        return "redirect:/users/profile-business";

    }

}