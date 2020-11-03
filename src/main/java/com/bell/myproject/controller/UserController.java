package com.bell.myproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/user")
public class UserController {
    
    @PostMapping("/list")
    public void getuserList() {

    }

    @GetMapping("/{id}")
    public void getUser(@PathVariable String id) {

    }

    @PostMapping("/update")
    public void updateUser() {

    }

    @PostMapping("/save")
    public void saveUser() {

    }
}
