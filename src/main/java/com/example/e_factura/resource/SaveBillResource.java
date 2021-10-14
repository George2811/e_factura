package com.example.e_factura.resource;

import com.example.e_factura.domain.model.TypeOfCurrency;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

public class SaveBillResource {

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

    @Column(nullable = false)
    private double ratePercentage;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TypeOfCurrency currency;

    @Column(nullable = false, scale = 2)
    private double nominalValue;

    @Column(nullable = false, scale = 2)
    private double initialExpenses;

    @Column(nullable = false, scale = 2)
    private double finalExpenses;

    @Column(nullable = true, scale = 2)
    private double retention;

    @Column(nullable = false)
    private double tcea;

    @Column(nullable = false, scale = 2)
    private double netWorth;

    @Column(nullable = false, scale = 2)
    private double deliveredValue;

    @Column(nullable = false, scale = 2)
    private double receivedValue;

    public String getName() {
        return name;
    }
    public SaveBillResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }
    public SaveBillResource setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public Calendar getIssue() {
        return issue;
    }
    public SaveBillResource setIssue(Calendar issue) {
        this.issue = issue;
        return this;
    }

    public Calendar getExpiration() {
        return expiration;
    }
    public SaveBillResource setExpiration(Calendar expiration) {
        this.expiration = expiration;
        return this;
    }

    public double getRatePercentage() {
        return ratePercentage;
    }
    public SaveBillResource setRatePercentage(double ratePercentage) {
        this.ratePercentage = ratePercentage;
        return this;
    }

    public TypeOfCurrency getCurrency() {
        return currency;
    }
    public SaveBillResource setCurrency(TypeOfCurrency currency) {
        this.currency = currency;
        return this;
    }

    public double getNominalValue() {
        return nominalValue;
    }
    public SaveBillResource setNominalValue(double nominalValue) {
        this.nominalValue = nominalValue;
        return this;
    }

    public double getInitialExpenses() {
        return initialExpenses;
    }
    public SaveBillResource setInitialExpenses(double initialExpenses) {
        this.initialExpenses = initialExpenses;
        return this;
    }

    public double getFinalExpenses() {
        return finalExpenses;
    }
    public SaveBillResource setFinalExpenses(double finalExpenses) {
        this.finalExpenses = finalExpenses;
        return this;
    }

    public double getRetention() {
        return retention;
    }
    public SaveBillResource setRetention(double retention) {
        this.retention = retention;
        return this;
    }

    public double getTcea() {
        return tcea;
    }
    public SaveBillResource setTcea(double tcea) {
        this.tcea = tcea;
        return this;
    }

    public double getNetWorth() {
        return netWorth;
    }
    public SaveBillResource setNetWorth(double netWorth) {
        this.netWorth = netWorth;
        return this;
    }

    public double getDeliveredValue() {
        return deliveredValue;
    }
    public SaveBillResource setDeliveredValue(double deliveredValue) {
        this.deliveredValue = deliveredValue;
        return this;
    }

    public double getReceivedValue() {
        return receivedValue;
    }
    public SaveBillResource setReceivedValue(double receivedValue) {
        this.receivedValue = receivedValue;
        return this;
    }
}
