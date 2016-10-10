package uk.gov.rifs.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import uk.gov.rifs.application.model.Application;
import uk.gov.rifs.application.model.Opportunity;

@Controller
public class ApplicationController {

    @Value("${dataservice.host}")
    String hostName;

    @Value("${dataservice.url.getsingleopportunity}")
    String singleOpportunityURL;

    @Value("${dataservice.url.getopportunitylist}")
    String opportunityListURL;

    String getSingleOpportunityURL() {
        return hostName + singleOpportunityURL;
    }

    String getOpportunityListURL() {
        return hostName + opportunityListURL;
    }

    @RequestMapping("/opportunitylinks")
    public String showOpportunityLinks(Model model) {
        return "/application/opportunitylinks";
    }

    /**
     * Method to get opportunity Overview
     *
     * @param id    (long)
     * @param model (Model)
     * @return opportunityApplicationoverview request map
     */
    @RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
    public String showOpportunityAppOverview(@PathVariable("id") long id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Opportunity opportunity = restTemplate.getForObject(getSingleOpportunityURL() + id, Opportunity.class);
        Application application = restTemplate.getForObject(getSingleOpportunityURL() + id + "/application", Application.class);
        model.addAttribute("opportunity", opportunity);
        model.addAttribute("app", application);

        return "application/applicationoverview";
    }
}
