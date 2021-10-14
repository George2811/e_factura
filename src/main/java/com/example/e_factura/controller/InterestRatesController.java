package com.example.e_factura.controller;

import com.example.e_factura.domain.model.InterestRate;
import com.example.e_factura.domain.service.InterestRateService;
import com.example.e_factura.resource.InterestRateResource;
import com.example.e_factura.resource.SaveInterestRateResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InterestRatesController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private InterestRateService interestRateService;

    @GetMapping("/interest-rates")
    public Page<InterestRateResource> getAllInterestRates(Pageable pageable){
        Page<InterestRate> interestRatesPage = interestRateService.getAllInterestRates(pageable);
        List<InterestRateResource> resources = interestRatesPage.getContent().
                stream().map(this::convertToResource).
                collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/interest-rates/{interestRateId}")
    public InterestRateResource getInterestRateById(@PathVariable Long interestRateId){
        InterestRate interestRate = interestRateService.getInterestRateById(interestRateId);
        return convertToResource(interestRate);
    }

    @PostMapping("/interest-rates")
    public InterestRateResource createInterestRate(@Valid @RequestBody SaveInterestRateResource resource){
        InterestRate interestRate = interestRateService.createInterestRate(convertToEntity(resource));
        return convertToResource(interestRate);
    }

    private InterestRate convertToEntity(SaveInterestRateResource resource){
        return mapper.map(resource, InterestRate.class);
    }

    private InterestRateResource convertToResource(InterestRate interestRate){
        return mapper.map(interestRate, InterestRateResource.class);
    }

}
