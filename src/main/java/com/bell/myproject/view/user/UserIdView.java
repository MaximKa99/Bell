package com.bell.myproject.view.user;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Класс для офиса, взятого пол id")
public class UserIdView{
    @ApiModelProperty(value = "id юзера")
    private Integer id;
    @ApiModelProperty(value = "id оффиса, в котором работает юзер")
    private int officeId;
    @ApiModelProperty(value = "имя юзера")
    private String firstName;
    @ApiModelProperty(value = "фамилия юзера")
    private String secondName;
    @ApiModelProperty(value = "отчество юзера")
    private String middleName;
    @ApiModelProperty(value = "должность юзера")
    private String position;
    @ApiModelProperty(value = "телефон юзера")
    private String phone;
    @ApiModelProperty(value = "имя документа бзера")
    private String docName;
    @ApiModelProperty(value = "номер документа юзера")
    private String docNumber;
    @ApiModelProperty(value = "код документа юзера")
    private int docCode;
    @ApiModelProperty(value = "дата документа юзера")
    private Date docDate;
    @ApiModelProperty(value = "код гражданства юзера")
    private int citizenshipCode;
    @ApiModelProperty(value = "гражданство юзера")
    private String citizenshipName;
    @ApiModelProperty(value = "статус юзера")
    private Boolean isIdentified;
}
