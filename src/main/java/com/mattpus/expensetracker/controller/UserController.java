package com.mattpus.expensetracker.controller;

import com.mattpus.expensetracker.exceptions.ResourceNotFoundException;
import com.mattpus.expensetracker.model.User;
import com.mattpus.expensetracker.model.UserModel;
import com.mattpus.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("profile")
    public ResponseEntity<User> get() {
        return new ResponseEntity<>(userService.read(), HttpStatus.OK);
    }

    @PutMapping("profile")
    public ResponseEntity<User> update(@RequestBody UserModel user) {
        User updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("deactivate")
    public ResponseEntity<HttpStatus> delete() throws ResourceNotFoundException {
        userService.delete();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

