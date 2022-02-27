package com.orhaninac.innovagraduationproject.business.dtos;

import com.orhaninac.innovagraduationproject.entities.CreditApplication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListUserDto {

    private String identityNumber;
    private String name;
    private String surname;
    private double salary;
    private String phoneNumber;
    private List<CreditApplication> applications;

}
