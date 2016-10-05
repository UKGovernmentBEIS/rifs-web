package uk.gov.rifs.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @RequestMapping("/opportunitylinks")
    public String showOpportunityLinks(Model model) {
        return "/application/opportunitylinks";
    }

}
