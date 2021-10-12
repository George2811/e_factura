package com.example.e_factura.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface Bill {
    Page<Bill> getAllBills(Pageable pageable);
    Bill getBillById(Long billId);
    Bill createBill(Long userID, Bill bill);
    Bill updateBill(Long billId, Long userID, Bill billRequest);
    ResponseEntity<?> deleteBill(Long billId, Long userID);
    Page<Bill> getAllBillByUserId(Long userId, Pageable pageable);
}