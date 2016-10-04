package uk.gov.rifs.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by venkata on 30/09/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paragraphs {

    private String paragraphs;

    public String getParagraphs() {
        return this.paragraphs;
    }

    public void setParagraphs(String paragraph) {
        this.paragraphs = paragraphs;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

}



