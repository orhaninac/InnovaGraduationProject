package com.orhaninac.innovagraduationproject.api.controller;

import com.orhaninac.innovagraduationproject.business.abstracts.CreditApplicationService;
import com.orhaninac.innovagraduationproject.business.dtos.CreateCreditApplicationDto;
import com.orhaninac.innovagraduationproject.business.requests.MakeApplicationRequest;
import com.orhaninac.innovagraduationproject.entities.CreditApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditApplication")
public class CreditApplicationController {

    CreditApplicationService creditApplicationService;
    @Autowired
    public CreditApplicationController(CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    @PostMapping("/makeApplication")
    public String add(@RequestBody MakeApplicationRequest makeApplicationRequest) {
        return this.creditApplicationService.calculateCreditScore(makeApplicationRequest);
    }




}
