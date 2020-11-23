package com.bell.myproject.controller;

import com.bell.myproject.service.User.UserService;
import com.bell.myproject.view.UserView;
import com.bell.myproject.view.data.Data;
import com.bell.myproject.view.data.DataList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public DataList getuserList(@RequestBody UserView userView) {
        return service.users(userView);
    }

    @GetMapping("/{id}")
    public Data getUser(@PathVariable int id) {
        return service.findUserById(id);
    }

    @PostMapping("/update")
    public Data updateUser(@RequestBody UserView userView) {
        return service.update(userView);
    }

    @PostMapping("/save")
    public Data saveUser(@RequestBody UserView userView) {
        return service.save(userView);
    }
}
