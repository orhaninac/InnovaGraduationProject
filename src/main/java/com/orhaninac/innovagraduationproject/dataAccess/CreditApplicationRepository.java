package com.orhaninac.innovagraduationproject.dataAccess;

import com.orhaninac.innovagraduationproject.entities.CreditApplication;
import com.orhaninac.innovagraduationproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication,Integer> {
    List<CreditApplication> getByUserId(int userId);
}
