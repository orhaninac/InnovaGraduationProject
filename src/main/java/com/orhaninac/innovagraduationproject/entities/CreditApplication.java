package com.orhaninac.innovagraduationproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="applications")
@Entity
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private long id;

    @Column(name = "credit_score")
    private double creditScore;

    @Column(name = "credit_status")
    private String creditStatus;

    @Column(name = "credit_limit")
    private double creditLimit;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

}
