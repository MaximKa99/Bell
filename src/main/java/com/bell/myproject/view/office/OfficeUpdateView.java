package com.bell.myproject.view.office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "класс для обновления оффиса")
public class OfficeUpdateView {
    @ApiModelProperty(required = true, value = "id оффиса")
    @NotNull(message = "Задайте id")
    private Integer id;
    @ApiModelProperty(required = true, value = "имя оффиса")
    @NotEmpty(message = "Задайте name")
    private String name;
    @ApiModelProperty(required = true, value = "аддресс оффиса")
    @NotEmpty(message = "Задайте address")
    private String address;
    @ApiModelProperty(value = "телефон оффиса")
    private String phone;
    @ApiModelProperty(value = "статус активности оффиса")
    private Boolean isActive;
}
