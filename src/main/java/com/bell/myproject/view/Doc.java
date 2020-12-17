package com.bell.myproject.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс типа документа")
public class Doc{
    @ApiModelProperty(value = "Название документа")
    private String name;
    @ApiModelProperty(value = "Код документа")
    private int code;
}
