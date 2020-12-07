package com.bell.myproject.controller;

import java.util.List;

import javax.validation.Valid;

import com.bell.myproject.service.organization.OrganizationService;
import com.bell.myproject.view.organization.ListOrganizationView;
import com.bell.myproject.view.organization.OrganizationFilter;
import com.bell.myproject.view.organization.OrganizationView;
import com.bell.myproject.view.organization.SaveOrganization;
import com.bell.myproject.view.organization.UpdateOrganization;
import com.bell.myproject.view.data.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("api/organization")
@Validated
@Api(value = "OrganizationController", description = "Управление информации о организациях")
public class OrganizationController {

    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping("/list")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = ListOrganizationView.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "список всех организаций", httpMethod = "POST")
    public List<ListOrganizationView> getListOfOrganization(@RequestBody @Valid OrganizationFilter filter) {
        List<ListOrganizationView> list = service.organizations(filter);
        return list;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "получить организацию по id", httpMethod = "GET")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = OrganizationView.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    public OrganizationView getOrganization(@PathVariable int id) {
        OrganizationView org = service.findById(id);
        return org;
    }

    @PostMapping("/update")
    @ApiOperation(value = "обновить организацию", httpMethod = "POST")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Result.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    public Result updateOrganization(@RequestBody @Valid UpdateOrganization update) {
        service.update(update);
        return new Result("Success");
    }

    @PostMapping("/save")
    @ApiOperation(value = "сохранить организацию", httpMethod = "POST")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Result.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    public Result saveOrganization(@RequestBody @Valid SaveOrganization save) {
        service.save(save);
        return new Result("Success");
    }
}
