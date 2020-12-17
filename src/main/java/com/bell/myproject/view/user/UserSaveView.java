package com.bell.myproject.view.user;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Класс для сохранения юзера")
public class UserSaveView {
    @ApiModelProperty(required = true, value = "id оффиса, в котором работает юзер")
    @NotNull(message = "Задайте officeId")
    private Integer officeId;
    @ApiModelProperty(required = true, value = "Имя юзера")
    @NotEmpty(message = "Задайте firstName")
    private String firstName;
    @ApiModelProperty(value = "Фамилия")
    private String secondName;
    @ApiModelProperty(value = "Отчество юзера")
    private String middleName;
    @ApiModelProperty(required = true, value = "Должность")
    @NotEmpty(message = "Задайте position")
    private String position;
    @ApiModelProperty(value = "Телефон юзера")
    private String phone;
    @ApiModelProperty(value = "тип документа")
    private Integer docCode;
    @ApiModelProperty(value = "имя документа")
    private String docName;
    @ApiModelProperty(value = "номер документа")
    private String docNumber;
    @ApiModelProperty(value = "дата документа")
    private Date docDate;
    @ApiModelProperty(value = "гражданство")
    private Integer citizenshipCode;
    @ApiModelProperty(value = "Статус юзера")
    private Boolean isIdentified;
}
