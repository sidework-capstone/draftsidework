package com.codeup.sidework.controllers;

import com.codeup.sidework.daos.PositionsRepository;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PositionsController {
    private final PositionsRepository positionsDao;

    public PositionsController(PositionsRepository positionsDao) {
        this.positionsDao = positionsDao;
    }

    protected Map positionFloorData(HttpServletRequest request) throws Exception {

        Map positionFloorData = new HashMap();
        List<String> jobListFloor = new ArrayList<String>();
        jobListFloor.add("Server");
        jobListFloor.add("Host");
        jobListFloor.add("Banquet Server");
        jobListFloor.add("Reservationist");
        positionFloorData.put("jobListFloor", jobListFloor);

        return positionFloorData;
    }

    protected Map positionBarData(HttpServletRequest request) throws Exception {

        Map positionBarData = new HashMap();
        List<String> jobListBar = new ArrayList<String>();
        jobListBar.add("Bartender");
        jobListBar.add("Barback");
        jobListBar.add("Cocktail Server");
        jobListBar.add("Sommelier");
        positionBarData.put("jobListBar", jobListBar);

        return positionBarData;

    }

    protected Map positionKitchenData(HttpServletRequest request) throws Exception {

        Map positionKitchenData = new HashMap();
        List<String> jobListKitchen = new ArrayList<String>();
        jobListKitchen.add("Line Cook");
        jobListKitchen.add("Prep Cook");
        jobListKitchen.add("Pastry Chef");
        jobListKitchen.add("Food Expo");
        positionKitchenData.put("jobListKitchen", jobListKitchen);

        return positionKitchenData;

    }

    protected Map positionSupportData(HttpServletRequest request) throws Exception {

        Map positionSupportData = new HashMap();
        List<String> jobListSupport = new ArrayList<String>();
        jobListSupport.add("Busser");
        jobListSupport.add("Dishwasher");
        jobListSupport.add("Utility Worker");
        jobListSupport.add("Repairman");
        positionSupportData.put("jobListSupport", jobListSupport);

        return positionSupportData;

    }

    protected Map positionOperatorsData(HttpServletRequest request) throws Exception{

        Map positionOperatorsData = new HashMap();
        List<String> jobListOperator = new ArrayList<String>();
        jobListOperator.add("Owner");
        jobListOperator.add("General Manager");
        jobListOperator.add("Executive Chef");
        jobListOperator.add("Beverage Director");
        jobListOperator.add("Assistant General Manager");
        jobListOperator.add("Sous Chef");
        jobListOperator.add("Events Director");
        positionOperatorsData.put("jobListOperator", jobListOperator);

        return positionOperatorsData;

    }

}
