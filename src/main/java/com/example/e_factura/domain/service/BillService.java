package com.example.e_factura.domain.service;

import com.example.e_factura.domain.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BillService {
    Page<Bill> getAllBills(Pageable pageable);
    Bill getBillByIdAndUserId(Long userId,Long billId);
    Bill createBill(Long userID, Bill bill, Long interestRateId);
    Bill updateBill(Long billId, Long userID, Bill billRequest);
    ResponseEntity<?> deleteBill(Long billId, Long userID);
    Page<Bill> getAllBillByUserId(Long userId, Pageable pageable);
}