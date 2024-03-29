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
    public String landingPage() {
        return "index";
    }

    @GetMapping("/aboutus")
    public String showAboutUsPage() {
        return "aboutus";
    }

    @GetMapping("/howitworks")
    public String showHowItWorksPage() {
        return "howitworks";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Worker worker = workerRepository.findByUser(user);
        if (worker != null) {
            return "redirect:/workers/profile/" + user.getId();
        }

        return "redirect:/businesses/profile/" + user.getId();
    }
}