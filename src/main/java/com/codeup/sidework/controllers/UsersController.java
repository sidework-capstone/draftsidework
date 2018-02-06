package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.User;
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
    private final UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UsersController(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

//    @GetMapping("/users/")
//    public String showLandingPage() {
//        return "users/landing-page";
//    }
                 // ^ this mapping will not work for the landing page, needs to go through the Home Controller

    @GetMapping("/users/register-worker")
    public String showWorkerRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register-worker";
    }

    @PostMapping("/users/register-worker")
    public String registerNewWorker(@ModelAttribute User user) {

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
        usersDao.save(user);
//        authenticate(user);
        return "redirect:/users/login-worker";
    }

    //// AUTHENTICATION OF USER WITH USERDETAILSLOADER
//    private void authenticate(User authenticatedUser) {
//        UserDetailsLoader userDetailsLoader = new UserWithRoles(authenticatedUser, Collections.emptyList());
//        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetailsLoader; userDetailsLoader.getPassword(), userDetailsLoader.getAuthorities());
//        SecurityContext context = SecurityContextHolder.getContext();
//        context.setAuthentication(authentication);
//    }

    @GetMapping("/users/workspace-worker")
    public String showWorkerWorkspace() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (user.getId() == 0) {
////            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return "redirect:/users/login-worker";
//        }

//        user = usersDao.findOne(user.getId());
//        model.addAttribute("user", user);
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

////  ADD VIEW ALL JOB LISTINGS TO WORKER WORKSPACE ^
//        Iterable<Listings> listings = listingsService.findAll();
//        model.addAttribute("listings", listings);
//
////  RESEARCH HOW TO BIND MULTIPLE CHECKBOXES TO ENTITIES
//    ModelAndView class documentation
//    @InitBinder
//    public void initBind(final WebDataBinder binder) {
//        binder.registerCustomEditor(Positions.class, new Positions());
//    }
