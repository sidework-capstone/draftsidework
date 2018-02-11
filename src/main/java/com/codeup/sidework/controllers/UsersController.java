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

@Controller
public class UsersController {
    private final UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UsersController(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    //FINDING A LIST OF USERS-------------------->
    @GetMapping("/users/index")
    public String showAllUsers(Model viewAndModel) {
        Iterable<User> users = usersDao.findAll();

        viewAndModel.addAttribute("users", users);

        return "users/index";
    }
}



//----------------------------------------------------------------------------------------------------
////  ADD VIEW ALL JOB LISTINGS TO WORKER WORKSPACE ^
//        Iterable<Listing> listings = listingsService.findAll();
//        model.addAttribute("listings", listings);
//
////  RESEARCH HOW TO BIND MULTIPLE CHECKBOXES TO ENTITIES
//    ModelAndView class documentation
//    @InitBinder
//    public void initBind(final WebDataBinder binder) {
//        binder.registerCustomEditor(Positions.class, new Positions());
//    }
