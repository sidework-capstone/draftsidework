package com.codeup.sidework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {



    @GetMapping("/login/worker")
    public String login() {
        return "users/login-worker";
    }

//    @GetMapping("/news/local/{title}")
//    public String showArticle(@PathVariable String title) {
//        // query the database for article where title like ?
//        // return a html response with the article contents
//        return "";
//    }
}