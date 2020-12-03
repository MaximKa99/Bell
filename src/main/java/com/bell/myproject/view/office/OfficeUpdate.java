package com.bell.myproject.view.office;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeUpdate {
    @Min(value = 1 ,message = "Задайте id")
    private int id;
    @NotEmpty(message = "Задайте name")
    private String name;
    @NotEmpty(message = "Задайте address")
    private String address;
    private String phone;
    private Boolean isActive;
}
