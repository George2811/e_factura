package com.example.e_factura.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Entity
@Table(name = "interest_rates")
public class InterestRate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TypeOfInterestRate type;

    @NotBlank
    @Column(name = "rate_time", nullable = false)
    private int rateTime;

    @Null
    @Column(name = "compounding_period", nullable = true)
    private int compoundingPeriod;

    public InterestRate() {
    }
    public InterestRate(Long id, TypeOfInterestRate type, int rateTime, int compoundingPeriod) {
        this.id = id;
        this.type = type;
        this.rateTime = rateTime;
        this.compoundingPeriod = compoundingPeriod;
    }

    public Long getId() {
        return id;
    }
    public InterestRate setId(Long id) {
        this.id = id;
        return this;
    }

    public TypeOfInterestRate getType() {
        return type;
    }
    public InterestRate setType(TypeOfInterestRate type) {
        this.type = type;
        return this;
    }

    public int getRateTime() {
        return rateTime;
    }
    public InterestRate setRateTime(int rateTime) {
        this.rateTime = rateTime;
        return this;
    }

    public int getCompoundingPeriod() {
        return compoundingPeriod;
    }
    public InterestRate setCompoundingPeriod(int compoundingPeriod) {
        this.compoundingPeriod = compoundingPeriod;
        return this;
    }
}
