package com.bell.myproject.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Класс для офиса, взятого пол id")
public class OrganizationIdView{
    @ApiModelProperty(value = "id организации")
    private Integer id;
    @ApiModelProperty(value = "имя организации")
    private String name;
    @ApiModelProperty(value = "полное имя организации")
    private String fullName;
    @ApiModelProperty(value = "аддресс организации")
    private String address;
    @ApiModelProperty(value = "инн организации")
    private String inn;
    @ApiModelProperty(value = "кпп организации")
    private String kpp;
    @ApiModelProperty(value = "телефон организации")
    private String phone;
    @ApiModelProperty(value = "статус организации")
    private Boolean isActive;
}
