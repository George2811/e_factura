package com.example.e_factura.domain.repository;

import com.example.e_factura.domain.model.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestRateRepository extends JpaRepository<InterestRate, Long> {

    Optional<InterestRate> findById(Long interestRateId);
}
