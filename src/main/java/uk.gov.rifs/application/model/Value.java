package uk.gov.rifs.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
        this.amount = amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OpportunityValueItem{" +
               ", unit='" + unit + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

}



