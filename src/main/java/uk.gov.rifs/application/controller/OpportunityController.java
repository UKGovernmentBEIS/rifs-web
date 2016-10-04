package uk.gov.rifs.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.client.RestTemplate;

@Controller
public class OpportunityController {

    @RequestMapping("/opportunitylist")
    public String showOpportunityList(Model model) {

        return "opportunity/opportunitylist";
    }

    @RequestMapping("/opportunityoverview")
    public String showOpportunityOverview(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        uk.gov.rifs.application.model.Opportunity opp = restTemplate.getForObject("http://rifs-business-rifs-test.test.int.ukrifs.org/opportunity/1", uk.gov.rifs.application.model.Opportunity.class);
        //log.info(quote.toString());
        System.out.println("HERE");
        System.out.println("opp.title = " + opp.getTitle() );
        System.out.println("opp = " + opp.toString());
        return "opportunity/opportunityoverview";


    }

    @RequestMapping("/opportunitydescription")
    public String showOpportunityDesription(Model model) {

        return "opportunity/opportunitydescription";
    }

    @RequestMapping("/opportunityuserroles")
    public String opportunityUserRoles(Model model) {

        return "opportunity/opportunityuserroles";
    }

}
