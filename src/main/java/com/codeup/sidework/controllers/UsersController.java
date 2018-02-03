package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.UserRepository;
import com.codeup.sidework.models.Positions;
import com.codeup.sidework.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {
    private final UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UsersController(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users/register-worker")
    public String showWorkerRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register-worker";
    }

    @PostMapping("/users/register-worker")
    public String registerNewWorker(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/users/login-worker";
    }


    @InitBinder
    public void initBind(final WebDataBinder binder) {
        binder.registerCustomEditor(Positions.class, new Positions());
    }
}


//    private Businesses businesses;
//    private Users users;
//    private PasswordEncoder passwordEncoder;
//    private final BusinessesRepository businessesRepository;
//    private final UserRepository usersRepository;
//
//    public UserController(Businesses businesses, Users users, BusinessesRepository businessesRepository,
//                          UserRepository usersRepository, PasswordEncoder passwordEncoder) {
//        this.businesses = businesses;
//        this.users = users;
//        this.businessesRepository = businessesRepository;
//        this.usersRepository = usersRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/users/register-mgmt")
//    public String showManagementRegisterForm(Model model) {
//        model.addAttribute("user", new User());
//        return "users/register-mgmt";
//    }
//
//    @PostMapping("/register")
//    public String saveManagement(@ModelAttribute Business business, @ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
////        businesses.save(business);
//        users.save(user);
//        return "redirect:/users/login-mgmt";
//    }
//
//    @GetMapping("/users/register-worker")
//    public String showWorkerRegisterForm(Model model) {
//        model.addAttribute("user", new User());
//        return "users/register-worker";
//    }
//
//    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
//    public String saveWorker(@ModelAttribute User user,
//                             @RequestParam(value = "optionsRadios") String[] checkboxValue,
//                             @RequestParam(value = "employed") boolean isEmployed,
//                             @RequestParam(value = "available") boolean isAvailable) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        user.setSkills(Arrays.toString(checkboxValue));
//        if (isEmployed) {
//            user.setCurrentEmployment(true);
//        } else {
//            user.setCurrentEmployment(false);
//        }
//
//        if (isAvailable) {
//            user.setAvailability(true);
//        } else {
//            user.setAvailability(false);
//        }
//
//        users.save(user);
//
//        return "redirect:/users/login-worker";
//    }
//
//    @GetMapping("/users/workspace-mgmt")
//    public String showManagementWorkspace() {
//        return "users/workspace-mgmt";
//    }
//
//    @GetMapping("/users/workspace-worker")
//    public String showWorkerWorkspace() {
//        return "users/workspace-worker";
//    }
//}
