package com.example.e_factura.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "bills")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true)
    private Long ruc;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar issue;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar expiration;

    @NotBlank
    @Column(nullable = false)
    private double ratePercentage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "interest_rate_id", nullable = false)
    @JsonIgnore
    private InterestRate interestRate;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TypeOfCurrency currency;

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double nominalValue;

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double initialExpenses;

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double finalExpenses;

    @NotBlank
    @Column(nullable = false)
    private double tcea;

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double netWorth;

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double deliveredValue;

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double receivedValue;

    public Bill() {
    }
    public Bill(Long id, String name, Long ruc, Calendar issue, Calendar expiration, double ratePercentage, TypeOfCurrency currency, double nominalValue, double initialExpenses, double finalExpenses, double tcea, double netWorth, double deliveredValue, double receivedValue) {
        this.id = id;
        this.name = name;
        this.ruc = ruc;
        this.issue = issue;
        this.expiration = expiration;
        this.ratePercentage = ratePercentage;
        this.currency = currency;
        this.nominalValue = nominalValue;
        this.initialExpenses = initialExpenses;
        this.finalExpenses = finalExpenses;
        this.tcea = tcea;
        this.netWorth = netWorth;
        this.deliveredValue = deliveredValue;
        this.receivedValue = receivedValue;
    }

    public Long getId() {
        return id;
    }
    public Bill setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }
    public Bill setUser(User user) {
        this.user = user;
        return this;
    }

    public String getName() {
        return name;
    }
    public Bill setName(String name) {
        this.name = name;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }
    public Bill setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public Calendar getIssue() {
        return issue;
    }
    public Bill setIssue(Calendar issue) {
        this.issue = issue;
        return this;
    }

    public Calendar getExpiration() {
        return expiration;
    }
    public Bill setExpiration(Calendar expiration) {
        this.expiration = expiration;
        return this;
    }

    public double getRatePercentage() {
        return ratePercentage;
    }
    public Bill setRatePercentage(double ratePercentage) {
        this.ratePercentage = ratePercentage;
        return this;
    }

    public InterestRate getInterestRate() {
        return interestRate;
    }
    public Bill setInterestRate(InterestRate interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public TypeOfCurrency getCurrency() {
        return currency;
    }
    public Bill setCurrency(TypeOfCurrency currency) {
        this.currency = currency;
        return this;
    }

    public double getNominalValue() {
        return nominalValue;
    }
    public Bill setNominalValue(double nominalValue) {
        this.nominalValue = nominalValue;
        return this;
    }

    public double getInitialExpenses() {
        return initialExpenses;
    }
    public Bill setInitialExpenses(double initialExpenses) {
        this.initialExpenses = initialExpenses;
        return this;
    }

    public double getFinalExpenses() {
        return finalExpenses;
    }
    public Bill setFinalExpenses(double finalExpenses) {
        this.finalExpenses = finalExpenses;
        return this;
    }

    public double getTcea() {
        return tcea;
    }
    public Bill setTcea(double tcea) {
        this.tcea = tcea;
        return this;
    }

    public double getNetWorth() {
        return netWorth;
    }
    public Bill setNetWorth(double netWorth) {
        this.netWorth = netWorth;
        return this;
    }

    public double getDeliveredValue() {
        return deliveredValue;
    }
    public Bill setDeliveredValue(double deliveredValue) {
        this.deliveredValue = deliveredValue;
        return this;
    }

    public double getReceivedValue() {
        return receivedValue;
    }
    public Bill setReceivedValue(double receivedValue) {
        this.receivedValue = receivedValue;
        return this;
    }
}
