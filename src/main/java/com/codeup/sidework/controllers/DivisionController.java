package com.codeup.sidework.controllers;

import com.codeup.sidework.models.Division;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DivisionController {

    @RequestMapping(value="/users/register-worker")
    private ModelAndView viewDivisionList() {
        ModelAndView mav = new ModelAndView("divisionsForm");

        List<String> divisionsList = new ArrayList<String>();
        divisionsList.add("Floor");
        divisionsList.add("Bar");
        divisionsList.add("Kitchen");
        divisionsList.add("Support");
        divisionsList.add("Operators");

        mav.addObject("divisionsList", divisionsList);
        mav.addObject("division", new Division());

        return mav;
    }


    @RequestMapping(value="/listings")
    private ModelAndView processDivsion(@ModelAttribute Division division) {
        ModelAndView mav = new ModelAndView("department-result");
        mav.addObject("division", division);

        return mav;
    }

}
