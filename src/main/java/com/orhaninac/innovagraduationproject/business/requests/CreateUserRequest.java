package com.orhaninac.innovagraduationproject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String identityNumber;
    private String name;
    private String surname;
    private double salary;
    private String phoneNumber;
}
