package com.bell.myproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/office")
public class OfficeController {
    
    @PostMapping("/list")
    public void getListOfOffice() {

    }

    @GetMapping("/{id}")
    public void getOffice(@PathVariable String id) {

    }

    @PostMapping("/update")
    public void updateOffice() {

    }

    @PostMapping("/save")
    public void saveOffice() {

    }
}
