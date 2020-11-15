package com.bell.myproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.bell.myproject.model.Organization;
import com.bell.myproject.service.Organization.OrganizationService;
import com.bell.myproject.view.Data;
import com.bell.myproject.view.DataList;
import com.bell.myproject.view.ListOrganizationView;
import com.bell.myproject.view.OrganizationView;
import com.bell.myproject.view.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/organization")
public class OrganizationController {

    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping("/list")
    public DataList getListOfOrganization(@RequestBody OrganizationView organizationView) {
        List<OrganizationView> organizationViews = service.organizations();
        return new DataList(organizationViews.stream().map(OrganizationService::toListOrganizationView).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Data getOrganization(@PathVariable Long id) {
        return new Data(service.findById(id));
    }

    @PostMapping("/update")
    public Data updateOrganization(@RequestBody OrganizationView organizationView) {
        service.update(organizationView);
        return new Data(new Result("Success"));
    }

    @PostMapping("/save")
    public Data saveOrganization(@RequestBody OrganizationView organizationView) {
        service.save(organizationView);
        return new Data(new Result("Success"));
    }
}
