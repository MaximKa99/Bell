package com.bell.myproject.view.user;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Фильтер-класс для юзера")
public class UserFilterView {
    @ApiModelProperty(required = true, value = "id оффиса, в котором работает юзер")
    @NotNull(message = "Задайте officeId")
    private Integer officeId;
    @ApiModelProperty(value = "Имя юзера")
    private String firstName;
    @ApiModelProperty(value = "Фамилия")
    private String secondName;
    @ApiModelProperty(value = "Отчество юзера")
    private String middleName;
    @ApiModelProperty(value = "Должность")
    private String position;
    @ApiModelProperty(value = "тип документа")
    private Integer docCode;
    @ApiModelProperty(value = "гражданство")
    private Integer citizenshipCode;
}
