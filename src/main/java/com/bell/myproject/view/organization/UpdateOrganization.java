package com.bell.myproject.view.organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrganization {
    @NotNull(message = "Задайте id")
    private Integer id;
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
