package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.daos.WorkerRepository;
import com.codeup.sidework.models.User;
import com.codeup.sidework.models.Worker;
import com.codeup.sidework.services.WorkerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WorkersController {
    private final WorkerRepository workerRepository;
    private final WorkerService workerSrv;
    private final UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public WorkersController(WorkerRepository workerRepository, WorkerService workerSrv, UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.workerRepository = workerRepository;
        this.workerSrv = workerSrv;
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/workers/create")
    public String showWorkerRegisterForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("worker", new Worker());
        return "workers/create";
    }

    @PostMapping("/workers/create")
    public String registerNewWorker(@ModelAttribute User user, @ModelAttribute Worker worker) {

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        worker.setUser(user);
        workerRepository.save(worker);
//        authenticate(user);
        return "redirect:/login";
    }

    @GetMapping("/workers/profile")
    public String viewWorkerProfile() {
        return "workers/profile";
    }

    //FINDING A USER BY ID-------------------->
    @GetMapping("/workers/profile/{id}")
    public String showWorkerProfile(@PathVariable long id, Model viewAndModel) { // Add a long id parameter
        // use the repository to find a user by its ID
        // .findOne(id)
        User user = usersDao.findOne(id);
        Worker worker = workerRepository.findByUser(user);
        // pass the user to the view, using a Model (viewmodel)
        viewAndModel.addAttribute("user", user);
        viewAndModel.addAttribute("worker", worker);
        return "workers/profile";
    }

    //FINDING A LIST OF WORKERS-------------------->
    @GetMapping("/workers/index")
    public String showAllWorkers(Model viewAndModel) {
        Iterable<Worker> workers = workerRepository.findAll();

        viewAndModel.addAttribute("workers", workers);

        return "workers/index";
    }

    @GetMapping("/workers/search")
    public String searchWorkers(@RequestParam("searchKeyword") String searchKeyword, Model viewModel) {
        viewModel.addAttribute("workers", workerSrv.searchForWorker(searchKeyword));
        return "workers/index";
    }
}
