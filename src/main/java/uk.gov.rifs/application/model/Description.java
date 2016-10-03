package uk.gov.rifs.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;

/**
 * Created by venkata on 30/09/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Description {

    private Long sectionNumber;
    private String title;
    private SectionParagraph sectionParagraph;

    public Long getSectionNumber() {
        return this.sectionNumber;
    }
    public String getTitle() {
        return this.title;
    }


    public void setSectionNumber(Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Opportunity{" +
                "sectionNumber=" + sectionNumber +
                ", title='" + title + '\'' +
                '}';
    }

}



