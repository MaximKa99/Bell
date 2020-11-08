package com.bell.myproject.controller;

import java.util.List;

import com.bell.myproject.dto.Organization;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/organization")
public class OrganizationController {

    @PostMapping("/list")
    public HttpEntity<List<Organization>> getListOfOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(null);
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
