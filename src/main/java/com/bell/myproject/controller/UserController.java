package com.bell.myproject.controller;

import com.bell.myproject.view.user.UserFilter;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserSave;
import com.bell.myproject.view.user.UserUpdate;
import com.bell.myproject.view.user.UserView;

import java.util.List;

import javax.validation.Valid;

import com.bell.myproject.service.user.UserService;
import com.bell.myproject.view.data.Data;
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
    public List<UserListView> getuserList(@RequestBody @Valid UserFilter filter) {
        List<UserListView> list = service.users(filter);
        return list;
    }

    @GetMapping("/{id}")
    public UserView getUser(@PathVariable int id) {
        return service.findUserById(id);
    }

    @PostMapping("/update")
    public Result updateUser(@RequestBody @Valid UserUpdate update) {
        service.update(update);
        return new Result("Success");
    }

    @PostMapping("/save")
    public Result saveUser(@RequestBody @Valid UserSave save) {
        service.save(save);
        return new Result("Success");
    }
}
