package uk.gov.rifs.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by venkata on 30/09/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private String unit;
    private Double amount;

    public String getUnit() {
        return this.unit;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
//        return "OpportunityValueItem{" +
//               ", unit='" + unit + '\'' +
//                ", amount='" + amount + '\'' +
//                '}';

        return ToStringBuilder.reflectionToString(this);
    }

}



