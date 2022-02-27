package com.orhaninac.innovagraduationproject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private int id;
    private String identityNumber;
    private String name;
    private String surname;
    private double salary;
    private String phoneNumber;
}
