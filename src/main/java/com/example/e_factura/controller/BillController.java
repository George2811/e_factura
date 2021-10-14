package com.example.e_factura.controller;

import com.example.e_factura.domain.model.Bill;
import com.example.e_factura.domain.service.BillService;
import com.example.e_factura.resource.SaveBillResource;
import com.example.e_factura.resource.BillResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/bills")
    public Page<BillResource> getAllBills(Pageable pageable) {
        Page<Bill> billPage = billService.getAllBills(pageable);
        List<BillResource> resources = billPage.getContent().
                stream().map(this::convertToResource).
                collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/user/{userId}/bills/{billId}")
    public BillResource getUserByIdAndBillById(@PathVariable(name = "userId") Long userId, @PathVariable(name = "billId") Long billId) {
        return convertToResource(billService.getBillByIdAndUserId(userId,billId));
    }

    private Bill convertToEntity(SaveBillResource resource) {
        return mapper.map(resource, Bill.class);
    }

    private BillResource convertToResource(Bill entity) {
        return mapper.map(entity, BillResource.class);
    }
}
