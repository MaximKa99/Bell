package com.bell.myproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OtherController {
    
    @PostMapping("api/docs")
    public void getDocs() {

    }

    @PostMapping("api/countries")
    public void getCountry() {
        
    }
}
