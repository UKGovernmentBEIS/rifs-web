package uk.gov.rifs.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.*;
import java.time.LocalDate;

/**
 * Created by venkata on 30/09/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Description {

    private Long sectionNumber;
    private String title;
    private List<String> paragraphs;

    public Long getSectionNumber() {
        return this.sectionNumber;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getParagraphs() {
        return this.paragraphs;
    }

    public void setSectionNumber(Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

}



