package com.orhaninac.innovagraduationproject.dataAccess;

import com.orhaninac.innovagraduationproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User getByIdentityNumber(String identityNumber);
    List<User> getAllByIdentityNumber(String identityNumber);
}
