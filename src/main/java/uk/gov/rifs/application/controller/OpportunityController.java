package uk.gov.rifs.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import uk.gov.rifs.application.model.Application;
import uk.gov.rifs.application.model.Description;
import uk.gov.rifs.application.model.Opportunity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for Opportunity Request mappings
 */

@Controller
@PropertySource("classpath:config.properties")
public class OpportunityController {

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

    /**
     * Method to get opportunitylist
     *
     * @param model (Model)
     * @return opportunitylist request map
     */
    @RequestMapping("/opportunitylist")
    public String showOpportunityList(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        List<Opportunity> opportunityList = Arrays.asList(restTemplate.getForObject(getOpportunityListURL(), Opportunity[].class));
        model.addAttribute("opportunityList", opportunityList);
        return "opportunity/opportunitylist";
    }

    /**
     * Method to get opportunity Overview
     *
     * @param id    (long)
     * @param model (Model)
     * @return opportunityoverview request map
     */
    @RequestMapping(value = "/opportunityoverview/{id}", method = RequestMethod.GET)
    public String showOpportunityOverview(@PathVariable("id") long id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Opportunity opportunity = restTemplate.getForObject(getSingleOpportunityURL() + id, Opportunity.class);
        Application application = restTemplate.getForObject(getSingleOpportunityURL() + id + "/application", Application.class);
        model.addAttribute("opportunity", opportunity);
        model.addAttribute("app", application);

        return "opportunity/opportunityoverview";
    }

    /**
     * Method to get opportunity details
     *
     * @param oppdescription (RequestParam)
     * @param id             (PathVariable)
     * @param model          (Model)
     * @return opportunitydetails request map
     */
    @RequestMapping(value = "/opportunitydetails/{id}", method = RequestMethod.GET)
    public String showOpportunityDetails(@RequestParam(name = "oppdescription", required = false) String oppdescription, @PathVariable("id") long id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Opportunity opportunity = restTemplate.getForObject(getSingleOpportunityURL() + id, Opportunity.class);

        model.addAttribute("opportunity", opportunity);
        if (oppdescription == null) oppdescription = "1";
        model.addAttribute("id", id);
        model.addAttribute("oppdescription", oppdescription);

        List<Description> descriptions = opportunity.getDescription();
        descriptions = descriptions.stream()
                .sorted((object1, object2) -> object1.getSectionNumber().compareTo(object2.getSectionNumber())).collect(Collectors.toList());
        model.addAttribute("descriptions", descriptions);

        return "opportunity/opportunitydetails";
    }

    /**
     * Method to get opportunity user roles page
     *
     * @param model (Model)
     * @return guidanceonseminarsforopp request map
     */
    @RequestMapping("/opportunityuserroles")
    public String opportunityUserRoles(Model model) {
        return "opportunity/opportunityuserroles";
    }

    @RequestMapping(value = "/guidance", method = RequestMethod.GET)
    public String guidance() {
        return "opportunity/guidanceonseminars";
    }

    @RequestMapping(value = "/opportunity/{id}/guidance", method = RequestMethod.GET)
    public String guidanceforopp(@PathVariable("id") long id, Model model) {
        model.addAttribute("id", id);
        return "opportunity/guidanceonseminarsforopp";
    }

}
