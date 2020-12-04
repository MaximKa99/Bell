package com.bell.myproject.view.organization;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrganization {
    @NotEmpty(message = "Задайте name")
    private String name;
    @NotEmpty(message = "Задайте fullName")
    private String fullName;
    @NotEmpty(message = "Задайте inn")
    private String inn;
    @NotEmpty(message = "Задайте kpp")
    private String kpp;
    @NotEmpty(message = "Задайте address")
    private String address;
    private String phone;
    private Boolean isActive;
}