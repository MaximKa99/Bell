package com.bell.myproject.controller;

import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserView;
import com.bell.myproject.service.user.UserService;
import com.bell.myproject.view.data.Data;
import com.bell.myproject.view.data.DataList;
import com.bell.myproject.view.data.Result;

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
    public DataList<UserListView> getuserList(@RequestBody UserView userView) {
        return new DataList<UserListView>(service.users(userView));
    }

    @GetMapping("/{id}")
    public Data<UserView> getUser(@PathVariable int id) {
        return new Data<UserView>(service.findUserById(id));
    }

    @PostMapping("/update")
    public Data<Result> updateUser(@RequestBody UserView userView) {
        service.update(userView);
        return new Data<Result>(new Result("Success"));
    }

    @PostMapping("/save")
    public Data<Result> saveUser(@RequestBody UserView userView) {
        service.save(userView);
        return new Data<Result>(new Result("Success"));
    }
}
