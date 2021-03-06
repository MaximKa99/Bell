package com.bell.myproject.controller;

import java.util.List;

import javax.validation.Valid;

import com.bell.myproject.service.office.OfficeService;
import com.bell.myproject.view.office.OfficeListView;
import com.bell.myproject.view.office.OfficeFilterView;
import com.bell.myproject.view.office.OfficeSaveView;
import com.bell.myproject.view.office.OfficeUpdateView;
import com.bell.myproject.view.office.OfficeIdView;
import com.bell.myproject.view.data.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = OfficeListView.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "список всех офисов", httpMethod = "POST")
    public List<OfficeListView> getListOfOffice(@RequestBody @Valid OfficeFilterView filter) {
        List<OfficeListView> list = service.offices(filter);
        return list;
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = OfficeIdView.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "получить офис по id", httpMethod = "GET")
    public OfficeIdView getOffice(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Result.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "обновить офис", httpMethod = "POST")
    public Result updateOffice(@RequestBody @Valid OfficeUpdateView update) {
        service.update(update);
        return new Result("Success");
    }

    @PostMapping("/save")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Result.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "сохранить офис", httpMethod = "POST")
    public Result saveOffice(@RequestBody @Valid OfficeSaveView save) {
        service.save(save);
        return new Result("Success");
    }
}
