package com.bell.myproject.view.organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationSaveView {
    @NotEmpty(message = "Задайте name")
    private String name;
    @NotEmpty(message = "Задайте fullName")
    private String fullName;
    @NotEmpty(message = "Задайте inn")
    @Size(min = 12, max = 12)
    private String inn;
    @NotEmpty(message = "Задайте kpp")
    @Size(min = 9, max = 9)
    private String kpp;
    @NotEmpty(message = "Задайте address")
    private String address;
    private String phone;
    private Boolean isActive;
}
