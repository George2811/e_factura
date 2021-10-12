package com.example.e_factura.resource;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

public class SaveBillResource {
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

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double nominalValue;

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double initialExpenses;

    @NotBlank
    @Column(nullable = false, scale = 2)
    private double finalExpenses;

    @Column(nullable = true, scale = 2)
    private double retention;

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
