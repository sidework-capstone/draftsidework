package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.daos.WorkerRepository;
import com.codeup.sidework.models.User;
import com.codeup.sidework.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class UsersController {
    private final WorkerRepository workerRepository;
    // This is an object that cannot be replaced by another
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

        //// AUTHENTICATION OF USERNAME/PASSWORD
//        public String registerNewWorker(@Valid User user, Errors validation, Model model) {
//        User existingUser = usersDao.findByUsername(user.getUsername());
//        if (existingUser != null) {
//            validation.rejectValue("username", "username", "this username is unavailable"); }
//        if (user.getPassword().equals("")) {
//            validation.rejectValue("password", "password", "password must be at least 5 characters"); }
        //// do we need to add another column to confirm password for authentication?
//        //        if (!user.getPassword().equals(user.getConfirmPassword())) {
//        //            validation.rejectValue("confirmPassword", "confirmPassword", "passwords must match");
//        //        }
//        if (validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("user", user);
//            return "users/register"; }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        worker.setUser(user);
        usersDao.save(user);
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
}
