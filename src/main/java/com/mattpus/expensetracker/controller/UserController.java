package com.mattpus.expensetracker.controller;

import com.mattpus.expensetracker.model.User;
import com.mattpus.expensetracker.model.UserModel;
import com.mattpus.expensetracker.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }
}
