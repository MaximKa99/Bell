package com.bell.myproject.controller;

import com.bell.myproject.checker.Organization.Checker;
import com.bell.myproject.exception.IncorrectOrganizationRequest;
import com.bell.myproject.service.Organization.OrganizationService;
import com.bell.myproject.view.OrganizationView;
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
@RequestMapping("api/organization")
public class OrganizationController {

    private final OrganizationService service;
    private final Checker checker;

    @Autowired
    public OrganizationController(OrganizationService service, Checker checker) {
        this.service = service;
        this.checker = checker;
    }

    @PostMapping("/list")
    public DataList getListOfOrganization(@RequestBody OrganizationView organizationView) {
        if (!checker.checkListRequest(organizationView)) {
            throw new IncorrectOrganizationRequest("Отсутствует поле name!!!");
        }
        return service.organizations(organizationView);
    }

    @GetMapping("/{id}")
    public Data getOrganization(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    public Data updateOrganization(@RequestBody OrganizationView organizationView) {
        if (!checker.checkUpdateRequest(organizationView))
            throw new IncorrectOrganizationRequest("Неправильно составлен запрос");
        service.update(organizationView);
        return new Data(new Result("Success"));
    }

    @PostMapping("/save")
    public Data saveOrganization(@RequestBody OrganizationView organizationView) {
        if (!checker.checkSaveRequest(organizationView))
            throw new IncorrectOrganizationRequest("Неправильно составлен запрос");
        service.save(organizationView);
        return new Data(new Result("Success"));
    }
}
