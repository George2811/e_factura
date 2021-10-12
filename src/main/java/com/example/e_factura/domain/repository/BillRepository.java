package com.example.e_factura.domain.repository;

import com.example.e_factura.domain.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

    Optional<Bill> findById(Long billId);
    Page<Bill> findByUserId(Long user_id, Pageable pageable);
}
