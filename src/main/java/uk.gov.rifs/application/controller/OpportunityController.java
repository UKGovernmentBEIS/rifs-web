package uk.gov.rifs.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OpportunityController {

    @RequestMapping("/opplist")
    public String showOpportunityList(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        return "opplist";
    }

}
