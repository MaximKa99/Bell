package com.bell.myproject.controller;

import java.util.List;
import com.bell.myproject.model.Organization;
import com.bell.myproject.service.Organization.OrganizationService;
import com.bell.myproject.view.OrganizationView;

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
    public List<OrganizationView> getListOfOrganization(@RequestBody OrganizationView organizationView) {
        List<OrganizationView> organizationViews = service.organizations();
        return organizationViews;
    }

    @GetMapping("/{id}")
    public OrganizationView getOrganization(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrganizationView organizationView) {
        service.update(organizationView);
    }

    @PostMapping("/save")
    public void saveOrganization(@RequestBody OrganizationView organizationView) {
        service.save(organizationView);
    }
}
