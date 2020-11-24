package com.bell.myproject.controller;

import com.bell.myproject.checker.Office.Checker;
import com.bell.myproject.exception.IncorrectOfficeRequest;
import com.bell.myproject.service.Office.OfficeService;
import com.bell.myproject.view.office.ListOfficeView;
import com.bell.myproject.view.office.OfficeView;
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
@RequestMapping("api/office")
public class OfficeController {
    private final OfficeService service;
    private final Checker checker;

    @Autowired
    public OfficeController(OfficeService service, Checker checker) {
        this.service = service;
        this.checker = checker;
    }

    @PostMapping("/list")
    public DataList<ListOfficeView> getListOfOffice(@RequestBody OfficeView officeView) {
        if (!checker.checkOfficeListRequest(officeView)) {
            throw new IncorrectOfficeRequest("Отсутствует поле orgId!!!");
        }
        return new DataList<ListOfficeView>(service.offices(officeView));
    }

    @GetMapping("/{id}")
    public Data<OfficeView> getOffice(@PathVariable int id) {
        return new Data<OfficeView>(service.findById(id));
    }

    @PostMapping("/update")
    public Data<Result> updateOffice(@RequestBody OfficeView officeView) {
        if (!checker.checkOfficeUpdate(officeView)) {
            throw new IncorrectOfficeRequest("Неправильно заполнен update request");
        }
        service.update(officeView);
        return new Data<Result>(new Result("Success"));
    }

    @PostMapping("/save")
    public Data<Result> saveOffice(@RequestBody OfficeView officeView) {
        if (!checker.checkOfficeSave(officeView)) {
            throw new IncorrectOfficeRequest("Неправильно заполнен save request");
        }
        service.save(officeView);
        return new Data<Result>(new Result("Success"));
    }
}
