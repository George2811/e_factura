package com.example.e_factura.resource;

import com.example.e_factura.domain.model.TypeOfInterestRate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

public class SaveInterestRateResource {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TypeOfInterestRate type;

    @Column(name = "rate_time", nullable = false)
    private int rateTime;

    @Column(name = "compounding_period", nullable = false)
    private int compoundingPeriod;

    public TypeOfInterestRate getType() {
        return type;
    }

    public SaveInterestRateResource setType(TypeOfInterestRate type) {
        this.type = type;
        return this;
    }

    public int getRateTime() {
        return rateTime;
    }

    public SaveInterestRateResource setRateTime(int rateTime) {
        this.rateTime = rateTime;
        return this;
    }

    public int getCompoundingPeriod() {
        return compoundingPeriod;
    }

    public SaveInterestRateResource setCompoundingPeriod(int compoundingPeriod) {
        this.compoundingPeriod = compoundingPeriod;
        return this;
    }
}
