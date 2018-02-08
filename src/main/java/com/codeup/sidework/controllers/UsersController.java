package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.daos.WorkerRepository;
import com.codeup.sidework.models.User;
import com.codeup.sidework.models.Worker;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private final WorkerRepository workerRepository;
    private final UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UsersController(UserRepository usersDao, PasswordEncoder passwordEncoder, WorkerRepository workerRepository) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
        this.workerRepository = workerRepository;
    }

    @GetMapping("/users/register-worker")
    public String showWorkerRegisterForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("worker", new Worker());
        return "users/register-worker";
    }

    @PostMapping("/users/register-worker")
    public String registerNewWorker(@ModelAttribute User user, @ModelAttribute Worker worker) {

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        worker.setUser(user);
        workerRepository.save(worker);
//        authenticate(user);
        return "redirect:/login";
    }


    @GetMapping("/users/workspace-worker")
    public String showWorkerWorkspace() {
        return "/users/workspace-worker";
    }

    @PostMapping("/users/workspace-worker")
    public String viewIndividualUsersWorkplace(@ModelAttribute User user) {
        return "/users/workspace-worker";
    }

    @GetMapping("/users/profile-worker")
    public String viewWorkerProfile() {
        return "users/profile-worker";
    }


    //FINDING A USER BY ID-------------------->
    @GetMapping("/users/profile-worker/{id}")
    public String showWorkerProfile(@PathVariable long id, Model viewAndModel) { // Add a long id parameter
        // use the repository to find a user by its ID
        // .findOne(id)
        User user = usersDao.findOne(id);
        Worker worker = workerRepository.findByUser(user);
        // pass the user to the view, using a Model (viewmodel)
        viewAndModel.addAttribute("user", user);
        viewAndModel.addAttribute("worker", worker);
        return "users/profile-worker";
    }


    //FINDING A LIST OF USERS-------------------->
    @GetMapping("/workers/index")
    public String showAllWorkers(Model viewAndModel) {
        Iterable<Worker> workers = workerRepository.findAll();

        viewAndModel.addAttribute("workers", workers);

        return "workers/index";
    }
}














