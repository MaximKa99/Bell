package com.bell.myproject.controller;

import java.util.List;

import com.bell.myproject.service.country.CountryService;
import com.bell.myproject.service.docs.DocService;
import com.bell.myproject.view.CitizenshipView;
import com.bell.myproject.view.Doc;

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
    public List<Doc> getDocs() {
        List<Doc> list = docService.all();
        return list;
    }

    @PostMapping("api/countries")
    public List<CitizenshipView> getCountry() {
        List<CitizenshipView> list = countryService.all();
        return list;
    }
}
