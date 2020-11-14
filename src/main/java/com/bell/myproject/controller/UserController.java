package com.bell.myproject.controller;

import java.util.List;

import com.bell.myproject.model.User;
import com.bell.myproject.service.User.UserService;
import com.bell.myproject.service.User.UserServiceImpl;
import com.bell.myproject.view.UserView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/list")
    public List<UserView> getuserList() {
        return service.users();
    }

    @GetMapping("/{id}")
    public void getUser(@PathVariable int id) {

    }

    @PostMapping("/update")
    public void updateUser() {

    }

    @PostMapping("/save")
    public void saveUser() {

    }
}
