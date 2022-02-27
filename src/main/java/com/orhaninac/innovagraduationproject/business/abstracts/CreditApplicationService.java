package com.orhaninac.innovagraduationproject.business.abstracts;

import com.orhaninac.innovagraduationproject.business.dtos.ListCreditApplicationDto;
import com.orhaninac.innovagraduationproject.business.dtos.CreateCreditApplicationDto;
import com.orhaninac.innovagraduationproject.business.requests.MakeApplicationRequest;

import java.util.List;

public interface CreditApplicationService {
    List<ListCreditApplicationDto> getAll();
    void add(CreateCreditApplicationDto createCreditApplicationRequest);

    ListCreditApplicationDto getById(int id);
    String calculateCreditScore(MakeApplicationRequest makeApplicationRequest);
}
