package com.example.e_factura.service;

import com.example.e_factura.domain.model.InterestRate;
import com.example.e_factura.domain.model.TypeOfInterestRate;
import com.example.e_factura.domain.repository.InterestRateRepository;
import com.example.e_factura.domain.service.InterestRateService;
import com.example.e_factura.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InterestRateServiceImpl implements InterestRateService {

    @Autowired
    private InterestRateRepository interestRateRepository;

    @Override
    public Page<InterestRate> getAllInterestRates(Pageable pageable) {
        return interestRateRepository.findAll(pageable);
    }

    @Override
    public InterestRate getInterestRateById(Long interestRateId) {
        return interestRateRepository.findById(interestRateId).orElseThrow(() -> new ResourceNotFoundException("Interest Rate", "Id", interestRateId));
    }

    @Override
    public InterestRate createInterestRate(InterestRate interestRate) {
        TypeOfInterestRate type = interestRate.getType();
        int time = interestRate.getRateTime();
        int period = interestRate.getCompoundingPeriod();

        InterestRate rate = interestRateRepository.findByTypeAndRateTimeAndCompoundingPeriod(type, time, period);

        if(rate != null){
            return interestRateRepository.findById(rate.getId()).orElseThrow(() -> new ResourceNotFoundException("Interest Rate", "Id", rate.getId()));
        }
        return interestRateRepository.save(interestRate);
    }
}
