package uk.gov.rifs.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import uk.gov.rifs.application.model.OpportunityValueItem;
import uk.gov.rifs.application.model.Description;
import java.util.*;

/**
 * Created by venkata on 30/09/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Opportunity {

    private Long id;
    private String title;
    //Needs to be a date
    private String startDate;
    //will be a list at some point
    private OpportunityValueItem valueItem;
    private List <Description> sections;

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }

}



