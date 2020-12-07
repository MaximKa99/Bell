package com.bell.myproject.controller;

import com.bell.myproject.view.user.UserFilterView;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserSaveView;
import com.bell.myproject.view.user.UserUpdateView;
import com.bell.myproject.view.user.UserIdView;

import java.util.List;

import javax.validation.Valid;

import com.bell.myproject.service.user.UserService;
import com.bell.myproject.view.data.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/user")
@Api(value = "UserController", description = "Управление информации о юзерах")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/list")
    @ApiOperation(value = "список всех юзеров", httpMethod = "POST")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = UserListView.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    public List<UserListView> getuserList(@RequestBody @Valid UserFilterView filter) {
        List<UserListView> list = service.users(filter);
        return list;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "получить юзера по id", httpMethod = "GET")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = UserIdView.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    public UserIdView getUser(@PathVariable int id) {
        return service.findUserById(id);
    }

    @PostMapping("/update")
    @ApiOperation(value = "обновить юзера", httpMethod = "POST")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Result.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    public Result updateUser(@RequestBody @Valid UserUpdateView update) {
        service.update(update);
        return new Result("Success");
    }

    @PostMapping("/save")
    @ApiOperation(value = "сохранить юзера", httpMethod = "POST")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Result.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    public Result saveUser(@RequestBody @Valid UserSaveView save) {
        service.save(save);
        return new Result("Success");
    }
}
