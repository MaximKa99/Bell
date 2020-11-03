package com.bell.myproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/organization")
public class OrganizationController {

    @PostMapping("/list")
    public void getListOfOrganization() {
    }

    @GetMapping("/{id}")
    public void getOrganization(@PathVariable String id) {
    }

    @PostMapping("/update")
    public void updateOrganization() {

    }

    @PostMapping("/save")
    public void saveOrganization() {

    }
}
