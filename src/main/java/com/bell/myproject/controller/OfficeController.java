package com.bell.myproject.controller;

import java.util.List;

import com.bell.myproject.service.Office.OfficeService;
import com.bell.myproject.view.OfficeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/office")
public class OfficeController {
    private final OfficeService service;

    @Autowired
    public OfficeController(OfficeService service) {
        this.service = service;
    }
    @PostMapping("/list")
    public List<OfficeView> getListOfOffice() {
        return service.offices();
    }

    @GetMapping("/{id}")
    public OfficeView getOffice(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    public void updateOffice() {

    }

    @PostMapping("/save")
    public void saveOffice() {

    }
}
