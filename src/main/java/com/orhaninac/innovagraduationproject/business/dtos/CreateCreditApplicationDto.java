package com.orhaninac.innovagraduationproject.business.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCreditApplicationDto {
    private int userID;
    private double creditScore;
    private String creditStatus;
    private double creditLimit;
}
