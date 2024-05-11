package com.dev.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.api.model.User;
import com.dev.api.service.user.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User signup(@Valid @RequestBody User user) {
       return userService.signup(user);
    }

    @GetMapping("login")
    public User login(@AuthenticationPrincipal User user) {
        return user;
    }
}
