package uk.gov.rifs.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OpportunityController {

    @RequestMapping("/opportunitylist")
    public String showOpportunityList(Model model) {

        return "/opportunity/opportunitylist";
    }

    @RequestMapping("/opportunityoverview")
    public String showOpportunityOverview(Model model) {

        return "/opportunity/opportunityoverview";
    }

    @RequestMapping("/opportunitydescription")
    public String showOpportunityDesription(Model model) {

        return "/opportunity/opportunitydescription";
    }

}
