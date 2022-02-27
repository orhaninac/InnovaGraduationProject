package com.orhaninac.innovagraduationproject.api.controller;

import com.orhaninac.innovagraduationproject.business.abstracts.UserService;
import com.orhaninac.innovagraduationproject.business.dtos.ListCreditApplicationDto;
import com.orhaninac.innovagraduationproject.business.requests.CreateUserRequest;
import com.orhaninac.innovagraduationproject.business.requests.UpdateUserRequest;
import com.orhaninac.innovagraduationproject.entities.CreditApplication;
import com.orhaninac.innovagraduationproject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void add(@RequestBody CreateUserRequest createUserRequest) {
        this.userService.add(createUserRequest);
    }


    @GetMapping("/getAllByIdentityNumber/{identityNumber}")
    public List<ListCreditApplicationDto> getAllByIdentityNumber(@RequestParam String identityNumber) {
        return userService.applications(identityNumber);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody int id) {
        this.userService.delete(id);
    }


    @PostMapping("/update")
    public void update(@RequestBody UpdateUserRequest user) {
        this.userService.update(user);
    }

}
