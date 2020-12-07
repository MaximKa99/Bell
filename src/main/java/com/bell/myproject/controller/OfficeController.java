package com.bell.myproject.controller;

import java.util.List;

import javax.validation.Valid;

import com.bell.myproject.service.office.OfficeService;
import com.bell.myproject.view.office.ListOfficeView;
import com.bell.myproject.view.office.OfficeFilter;
import com.bell.myproject.view.office.OfficeSave;
import com.bell.myproject.view.office.OfficeUpdate;
import com.bell.myproject.view.office.OfficeView;
import com.bell.myproject.view.data.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/office")
@Api(value = "OfficeController", description = "Управление информации о оффисах")
public class OfficeController {
    private final OfficeService service;

    @Autowired
    public OfficeController(OfficeService service) {
        this.service = service;
    }

    @PostMapping("/list")
    public List<ListOfficeView> getListOfOffice(@RequestBody @Valid OfficeFilter filter) {
        List<ListOfficeView> list = service.offices(filter);
        return list;
    }

    @GetMapping("/{id}")
    public OfficeView getOffice(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    public Result updateOffice(@RequestBody @Valid OfficeUpdate update) {
        service.update(update);
        return new Result("Success");
    }

    @PostMapping("/save")
    public Result saveOffice(@RequestBody @Valid OfficeSave save) {
        service.save(save);
        return new Result("Success");
    }
}
