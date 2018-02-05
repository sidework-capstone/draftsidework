package com.codeup.sidework.controllers;

import com.codeup.sidework.models.Positions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PositionsController {


   @RequestMapping(value="/users/register-worker")
   private ModelAndView viewFloorPositionsList() {
   ModelAndView mav = new ModelAndView("floorPositionForm");

        List<String> floorPositionsList = new ArrayList<String>();
        floorPositionsList.add("Server");
        floorPositionsList.add("Host");
        floorPositionsList.add("Banquet Server");
        floorPositionsList.add("Reservationist");


        mav.addObject("floorPositionsList", floorPositionsList);
        mav.addObject("positions", new Positions());

        return mav;
    }

    @RequestMapping(value="/users/register-worker")
    private ModelAndView viewBarPositionsList() {
    ModelAndView mav = new ModelAndView("barPositionForm");

        List<String> barPositionsList = new ArrayList<String>();
        barPositionsList.add("Bartender");
        barPositionsList.add("Barback");
        barPositionsList.add("Cocktail Server");
        barPositionsList.add("Sommelier");

        mav.addObject("barPositionsList", barPositionsList);
        mav.addObject("positions", new Positions());

        return mav;

    }

    @RequestMapping(value="/users/register-worker")
    private ModelAndView viewKitchenPositionsList() {
    ModelAndView mav = new ModelAndView("kitchenPositionForm");

        List<String> kitchenPositionsList = new ArrayList<String>();
        kitchenPositionsList.add("Line Cook");
        kitchenPositionsList.add("Prep Cook");
        kitchenPositionsList.add("Pastry Chef");
        kitchenPositionsList.add("Food Expo");

        mav.addObject("kitchenPositionsList", kitchenPositionsList);
        mav.addObject("positions", new Positions());

        return mav;

    }

    @RequestMapping(value="/users/register-worker")
    private ModelAndView viewSupportPositionsList() {
    ModelAndView mav = new ModelAndView("supportPositionForm");

        List<String> supportPositionsList = new ArrayList<String>();
        supportPositionsList.add("Busser");
        supportPositionsList.add("Dishwasher");
        supportPositionsList.add("Utility Worker");
        supportPositionsList.add("Repairman");

        mav.addObject("supportPositionsList", supportPositionsList);
        mav.addObject("positions", new Positions());

        return mav;

    }

    @RequestMapping(value="/users/register-worker")
    private ModelAndView viewOperatorPositionsList() {
    ModelAndView mav = new ModelAndView("operatorPositionForm");

        List<String> operatorPositionsList = new ArrayList<String>();
        operatorPositionsList.add("Owner");
        operatorPositionsList.add("General Manager");
        operatorPositionsList.add("Executive Chef");
        operatorPositionsList.add("Beverage Director");
        operatorPositionsList.add("Assistant General Manager");
        operatorPositionsList.add("Sous Chef");
        operatorPositionsList.add("Events Director");

        mav.addObject("operatorPositionsList", operatorPositionsList);
        mav.addObject("positions", new Positions());

        return mav;

    }



    @RequestMapping(value="/listings/floor-positions")
    private ModelAndView processFloorPositions(@ModelAttribute Positions positions){
       ModelAndView mav = new ModelAndView("positions-result");

       mav.addObject("Positions", positions);
       return mav;
    }

    @RequestMapping(value="/listings/bar-positions")
    private ModelAndView processBarPositions(@ModelAttribute Positions positions){
        ModelAndView mav = new ModelAndView("positions-result");

        mav.addObject("Positions", positions);
        return mav;
    }

    @RequestMapping(value="/listings/kitchen-positions")
    private ModelAndView processKitchenPositions(@ModelAttribute Positions positions){
        ModelAndView mav = new ModelAndView("positions-result");

        mav.addObject("Positions", positions);
        return mav;
    }

    @RequestMapping(value="/listings/support-positions")
    private ModelAndView processSupportPositions(@ModelAttribute Positions positions){
        ModelAndView mav = new ModelAndView("positions-result");

        mav.addObject("Positions", positions);
        return mav;
    }

    @RequestMapping(value="/listings/operator-positions")
    private ModelAndView processOperatorPositions(@ModelAttribute Positions positions){
        ModelAndView mav = new ModelAndView("positions-result");

        mav.addObject("Positions", positions);
        return mav;
    }

}
