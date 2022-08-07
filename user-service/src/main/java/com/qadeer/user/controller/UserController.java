package com.qadeer.user.controller;


import com.qadeer.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.qadeer.user.service.UserService;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET methods
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws IOException {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<User>(user, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // POST methods
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable int id, @RequestBody String status) throws IOException {
        String message = userService.updateUserById(id, status);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
