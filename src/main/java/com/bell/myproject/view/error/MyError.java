package com.bell.myproject.view.error;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс для ошибок")
public class MyError<T> {
    @ApiModelProperty(value = "Ошибка")
    private T error;
}
