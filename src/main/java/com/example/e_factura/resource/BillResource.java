package com.example.e_factura.resource;

import com.example.e_factura.domain.model.InterestRate;
import com.example.e_factura.domain.model.TypeOfCurrency;
import com.example.e_factura.domain.model.User;

import java.util.Calendar;

public class BillResource {
    private Long id;
    private Long userId;
    private String name;
    private Long ruc;
    private Calendar issue;
    private Calendar expiration;
    private double ratePercentage;
    private Long interestRateId;
    private TypeOfCurrency currency;
    private double nominalValue;
    private double initialExpenses;
    private double finalExpenses;
    private double retention;
    private double tcea;
    private double netWorth;
    private double deliveredValue;
    private double receivedValue;

    public Long getId() {
        return id;
    }
    public BillResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }
    public BillResource setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }
    public BillResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }
    public BillResource setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public Calendar getIssue() {
        return issue;
    }
    public BillResource setIssue(Calendar issue) {
        this.issue = issue;
        return this;
    }

    public Calendar getExpiration() {
        return expiration;
    }
    public BillResource setExpiration(Calendar expiration) {
        this.expiration = expiration;
        return this;
    }

    public double getRatePercentage() {
        return ratePercentage;
    }
    public BillResource setRatePercentage(double ratePercentage) {
        this.ratePercentage = ratePercentage;
        return this;
    }

    public Long getInterestRateId() {
        return interestRateId;
    }
    public BillResource setInterestRateId(Long interestRateId) {
        this.interestRateId = interestRateId;
        return this;
    }

    public TypeOfCurrency getCurrency() {
        return currency;
    }
    public BillResource setCurrency(TypeOfCurrency currency) {
        this.currency = currency;
        return this;
    }

    public double getNominalValue() {
        return nominalValue;
    }
    public BillResource setNominalValue(double nominalValue) {
        this.nominalValue = nominalValue;
        return this;
    }

    public double getInitialExpenses() {
        return initialExpenses;
    }
    public BillResource setInitialExpenses(double initialExpenses) {
        this.initialExpenses = initialExpenses;
        return this;
    }

    public double getFinalExpenses() {
        return finalExpenses;
    }
    public BillResource setFinalExpenses(double finalExpenses) {
        this.finalExpenses = finalExpenses;
        return this;
    }

    public double getRetention() {
        return retention;
    }
    public BillResource setRetention(double retention) {
        this.retention = retention;
        return this;
    }

    public double getTcea() {
        return tcea;
    }
    public BillResource setTcea(double tcea) {
        this.tcea = tcea;
        return this;
    }

    public double getNetWorth() {
        return netWorth;
    }
    public BillResource setNetWorth(double netWorth) {
        this.netWorth = netWorth;
        return this;
    }

    public double getDeliveredValue() {
        return deliveredValue;
    }
    public BillResource setDeliveredValue(double deliveredValue) {
        this.deliveredValue = deliveredValue;
        return this;
    }

    public double getReceivedValue() {
        return receivedValue;
    }
    public BillResource setReceivedValue(double receivedValue) {
        this.receivedValue = receivedValue;
        return this;
    }
}
