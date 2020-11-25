package com.bell.myproject.controller;

import java.util.List;

import com.bell.myproject.checker.organization.Checker;
import com.bell.myproject.exception.IncorrectOrganizationRequest;
import com.bell.myproject.service.organization.OrganizationService;
import com.bell.myproject.view.organization.ListOrganizationView;
import com.bell.myproject.view.organization.OrganizationView;
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
    public DataList<ListOrganizationView> getListOfOrganization(@RequestBody OrganizationView organizationView) {
        if (!checker.checkListRequest(organizationView)) {
            throw new IncorrectOrganizationRequest("Отсутствует поле name!!!");
        }
        List<ListOrganizationView> list = service.organizations(organizationView);
        return new DataList<ListOrganizationView>(list);
    }

    @GetMapping("/{id}")
    public Data<OrganizationView> getOrganization(@PathVariable int id) {
        OrganizationView org = service.findById(id);
        return new Data<OrganizationView>(org);
    }

    @PostMapping("/update")
    public Data<Result> updateOrganization(@RequestBody OrganizationView organizationView) {
        if (!checker.checkUpdateRequest(organizationView))
            throw new IncorrectOrganizationRequest("Неправильно составлен запрос");
        service.update(organizationView);
        return new Data<Result>(new Result("Success"));
    }

    @PostMapping("/save")
    public Data<Result> saveOrganization(@RequestBody OrganizationView organizationView) {
        if (!checker.checkSaveRequest(organizationView))
            throw new IncorrectOrganizationRequest("Неправильно составлен запрос");
        service.save(organizationView);
        return new Data<Result>(new Result("Success"));
    }
}
