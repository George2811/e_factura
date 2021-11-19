package com.example.e_factura.service;

import com.example.e_factura.domain.model.Bill;
import com.example.e_factura.domain.model.InterestRate;
import com.example.e_factura.domain.repository.BillRepository;
import com.example.e_factura.domain.repository.InterestRateRepository;
import com.example.e_factura.domain.repository.UserRepository;
import com.example.e_factura.domain.service.BillService;
import com.example.e_factura.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private InterestRateRepository interestRateRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Bill> getAllBills(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public Bill getBillByIdAndUserId(Long userId, Long billId) {
        return billRepository.findByIdAndUserId(billId, userId).orElseThrow(() -> new ResourceNotFoundException("Bill not found with Id " + billId + " and UserId " + userId));
    }

    @Override
    public Bill createBill(Long userID, Bill bill, Long interestRateId) {
        return userRepository.findById(userID).map(user -> {
            InterestRate interestRate = interestRateRepository.findById(interestRateId).orElseThrow(() -> new ResourceNotFoundException("Interest Rate", "Id", interestRateId));
            if(interestRate == null){
                throw new ResourceNotFoundException("InterestRate", "Id", interestRateId);
            }
            bill.setUser(user);
            bill.setInterestRate(interestRate);
            return billRepository.save(bill);
        }).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userID));
    }

    @Override // No hay update de Bill :(
    public Bill updateBill(Long billId, Long userID, Bill billRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteBill(Long userID, Long billId) {
        if(!userRepository.existsById(userID))
            throw new ResourceNotFoundException("User", "Id", userID);
        return billRepository.findById(billId).map(bill -> {
            billRepository.delete(bill);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Bill", "Id", billId));
    }

    @Override
    public Page<Bill> getAllBillByUserId(Long userId, Pageable pageable) {
        return billRepository.findByUserId(userId, pageable);
    }
}
