package com.example.e_factura.resource;

import com.example.e_factura.domain.model.InterestRate;
import com.example.e_factura.domain.model.TypeOfCurrency;
import com.example.e_factura.domain.model.User;

import java.util.Calendar;

public class BillResource {
    private Long id;
    private User user;
    private String name;
    private Long ruc;
    private Calendar issue;
    private Calendar expiration;
    private double ratePercentage;
    private InterestRate interestRate;
    private TypeOfCurrency currency;

    public Long getId() {
        return id;
    }

    public BillResource setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public BillResource setUser(User user) {
        this.user = user;
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

    public InterestRate getInterestRate() {
        return interestRate;
    }

    public BillResource setInterestRate(InterestRate interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public TypeOfCurrency getCurrency() {
        return currency;
    }

    public BillResource setCurrency(TypeOfCurrency currency) {
        this.currency = currency;
        return this;
    }
}
