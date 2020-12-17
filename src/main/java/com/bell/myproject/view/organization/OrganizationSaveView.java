package com.bell.myproject.view.organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Класс для сохранения организации")
public class OrganizationSaveView {
    @ApiModelProperty(required = true, value = "Имя организации")
    @NotEmpty(message = "Задайте name")
    private String name;
    @ApiModelProperty(required = true, value = "Полное имя организации")
    @NotEmpty(message = "Задайте fullName")
    private String fullName;
    @ApiModelProperty(required = true, value = "Инн организации")
    @NotEmpty(message = "Задайте inn")
    @Size(min = 12, max = 12)
    private String inn;
    @ApiModelProperty(required = true, value = "Кпп организации")
    @NotEmpty(message = "Задайте kpp")
    @Size(min = 9, max = 9)
    private String kpp;
    @ApiModelProperty(required = true, value = "Аддресс организации")
    @NotEmpty(message = "Задайте address")
    private String address;
    @ApiModelProperty(value = "Телефон организации")
    private String phone;
    @ApiModelProperty(value = "Статус активности организации")
    private Boolean isActive;
}
