package com.bell.myproject.controller;

import com.bell.myproject.service.country.CountryService;
import com.bell.myproject.service.docs.DocService;
import com.bell.myproject.view.data.DataList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OtherController {
    private DocService docService;
    private CountryService countryService;

    @Autowired
    public OtherController(DocService docService, CountryService countryService) {
        this.docService = docService;
        this.countryService = countryService;
    }

    @PostMapping("api/docs")
    public DataList getDocs() {
        return docService.all();
    }

    @PostMapping("api/countries")
    public DataList getCountry() {
        return countryService.all();
    }
}
