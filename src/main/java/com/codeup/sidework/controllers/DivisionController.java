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
    private ModelAndView viewFOHDivisionList() {
        ModelAndView mav = new ModelAndView("fohDivisionsForm");

        List<String> fohDivisionsList = new ArrayList<String>();
        fohDivisionsList.add("Floor");
        fohDivisionsList.add("Bar");

        mav.addObject("fohDivisionsList", fohDivisionsList);
        mav.addObject("division", new Division());

        return mav;
    }

    @RequestMapping(value="/users/register-worker")
    private ModelAndView viewBOHDivisionList() {
        ModelAndView mav = new ModelAndView("bohDivisionsForm");

        List<String> bohDivisionsList = new ArrayList<String>();
        bohDivisionsList.add("Kitchen");
        bohDivisionsList.add("Support");

        mav.addObject("bohDivisionsList", bohDivisionsList);
        mav.addObject("division", new Division());

        return mav;
    }

    @RequestMapping(value="/users/register-worker")
    private ModelAndView viewOperatorDivisionList() {
        ModelAndView mav = new ModelAndView("operatorDivisionsForm");

        List<String> operatorDivisionsList = new ArrayList<String>();
        operatorDivisionsList.add("Operators");

        mav.addObject("operatorDivisionsList", operatorDivisionsList);
        mav.addObject("division", new Division());

        return mav;
    }


    @RequestMapping(value="/listings")
    private ModelAndView processFOHDivsion(@ModelAttribute Division division) {
        ModelAndView mav = new ModelAndView("division-result");
        mav.addObject("division", division);

        return mav;
    }

    @RequestMapping(value="/listings")
    private ModelAndView processBOHDivsion(@ModelAttribute Division division) {
        ModelAndView mav = new ModelAndView("division-result");
        mav.addObject("division", division);

        return mav;
    }


    @RequestMapping(value="/listings")
    private ModelAndView operatorDivsion(@ModelAttribute Division division) {
        ModelAndView mav = new ModelAndView("division-result");
        mav.addObject("division", division);

        return mav;
    }


}

