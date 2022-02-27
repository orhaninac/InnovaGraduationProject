package com.orhaninac.innovagraduationproject.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_identity_number")
    private String identityNumber;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_salary")
    private double salary;

    @Column(name = "user_phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CreditApplication> applications;

}
