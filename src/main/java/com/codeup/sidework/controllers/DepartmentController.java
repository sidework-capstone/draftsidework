package com.codeup.sidework.controllers;

import com.codeup.sidework.models.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {

    @RequestMapping(value="/users/register-worker")
    private ModelAndView viewDepartmentList() {
        ModelAndView mav = new ModelAndView("departmentsForm");

        List<String> departmentsList = new ArrayList<String>();
        departmentsList.add("Front of House");
        departmentsList.add("Back of House");
        departmentsList.add("Operators");

        mav.addObject("departmentsList", departmentsList);
        mav.addObject("department", new Department());

        return mav;
    }


    @RequestMapping(value="/listings")
    private ModelAndView processDepartments(@ModelAttribute Department department) {
        ModelAndView mav = new ModelAndView("department-result");
        mav.addObject("department", department);

        return mav;
    }

}
