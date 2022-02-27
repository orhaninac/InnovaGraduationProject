package com.orhaninac.innovagraduationproject.business.abstracts;

import com.orhaninac.innovagraduationproject.business.dtos.ListCreditApplicationDto;
import com.orhaninac.innovagraduationproject.business.dtos.ListUserDto;
import com.orhaninac.innovagraduationproject.business.requests.CreateUserRequest;

import java.util.List;

import com.orhaninac.innovagraduationproject.business.requests.UpdateUserRequest;
import com.orhaninac.innovagraduationproject.entities.CreditApplication;
import com.orhaninac.innovagraduationproject.entities.User;
import org.springframework.stereotype.Service;

public interface UserService {
    List<ListUserDto> getAll();
    User add(CreateUserRequest createCarRequest);
    ListUserDto getById(int id);
    User update(UpdateUserRequest updateUserRequest);
    void delete(int id);
    List<ListCreditApplicationDto> applications(String identityNumber);
}
