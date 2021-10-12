package com.example.e_factura.resource;

import com.example.e_factura.domain.model.TypeOfInterestRate;

public class InterestRateResource {
    private Long id;
    private int rateTime;
    private int compoundingPeriod;
    private TypeOfInterestRate type;

    public Long getId() {
        return id;
    }

    public InterestRateResource setId(Long id) {
        this.id = id;
        return this;
    }

    public int getRateTime() {
        return rateTime;
    }

    public InterestRateResource setRateTime(int rateTime) {
        this.rateTime = rateTime;
        return this;
    }

    public int getCompoundingPeriod() {
        return compoundingPeriod;
    }

    public InterestRateResource setCompoundingPeriod(int compoundingPeriod) {
        this.compoundingPeriod = compoundingPeriod;
        return this;
    }

    public TypeOfInterestRate getType() {
        return type;
    }

    public InterestRateResource setType(TypeOfInterestRate type) {
        this.type = type;
        return this;
    }
}
