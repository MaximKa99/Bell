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

@RestController
@RequestMapping("api/organization")
@Validated
public class OrganizationController {

    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping("/list")
    public List<ListOrganizationView> getListOfOrganization(@RequestBody @Valid OrganizationFilter filter) {
        List<ListOrganizationView> list = service.organizations(filter);
        return list;
    }

    @GetMapping("/{id}")
    public OrganizationView getOrganization(@PathVariable int id) {
        OrganizationView org = service.findById(id);
        return org;
    }

    @PostMapping("/update")
    public Result updateOrganization(@RequestBody @Valid UpdateOrganization update) {
        service.update(update);
        return new Result("Success");
    }

    @PostMapping("/save")
    public Result saveOrganization(@RequestBody @Valid SaveOrganization save) {
        service.save(save);
        return new Result("Success");
    }
}
