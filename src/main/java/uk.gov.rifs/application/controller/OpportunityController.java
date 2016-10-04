package uk.gov.rifs.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import uk.gov.rifs.application.model.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Controller
@PropertySource("classpath:config.properties")
public class OpportunityController {

    @Value("${dataservice.url.getsingleopportunity}")
    String getSingleOpportunityURL;

    @RequestMapping("/opportunitylist")
    public String showOpportunityList(Model model) {

        return "opportunity/opportunitylist";
    }

    @RequestMapping(value="/opportunityoverview/{id}", method= RequestMethod.GET)
    public String showOpportunityOverview(@PathVariable("id") long id, Model model) {

        RestTemplate restTemplate = new RestTemplate();

        Opportunity opportunity = restTemplate.getForObject(getSingleOpportunityURL + id, Opportunity.class);

        model.addAttribute("opportunity", opportunity);

        return "opportunity/opportunityoverview";

    }

    @RequestMapping(value="/opportunitydescription/{id}", method= RequestMethod.GET)
    public String showOpportunityDesription(@PathVariable("id") long id, Model model) {

        RestTemplate restTemplate = new RestTemplate();

        Opportunity opportunity = restTemplate.getForObject(getSingleOpportunityURL + id, Opportunity.class);

        model.addAttribute("opportunity", opportunity);

        return "opportunity/opportunitydescription";
    }

}
