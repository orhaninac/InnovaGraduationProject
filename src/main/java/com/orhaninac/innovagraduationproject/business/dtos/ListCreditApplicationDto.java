package com.orhaninac.innovagraduationproject.business.dtos;

import com.orhaninac.innovagraduationproject.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCreditApplicationDto {
    String userName;
    String userSurname;
    private double creditScore;
    private String creditStatus;
    private double userSalary;
    private double creditLimit;
}
