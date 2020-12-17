package com.bell.myproject.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Класс гражданства")
public class CitizenshipView{
    @ApiModelProperty(value = "Название страны")
    private String name;
    @ApiModelProperty(value = "код страны")
    private int code;
}
