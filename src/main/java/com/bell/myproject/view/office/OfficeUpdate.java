package com.bell.myproject.view.office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeUpdate {
    @NotNull(message = "Задайте id")
    private Integer id;
    @NotEmpty(message = "Задайте name")
    private String name;
    @NotEmpty(message = "Задайте address")
    private String address;
    private String phone;
    private Boolean isActive;
}
