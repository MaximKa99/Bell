package com.bell.myproject.view.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Класс для возвращаемых данных")
public class Data<T> {
    @ApiModelProperty(value = "Данные")
    private T data;
}
