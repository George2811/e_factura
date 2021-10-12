package com.example.e_factura.domain.service;

import com.example.e_factura.domain.model.InterestRate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterestRateService {
    Page<InterestRate> getAllInterestRates(Pageable pageable);
    InterestRate getInterestRateById(Long interestRateId);
    InterestRate createInterestRate(InterestRate interestRate);
}
