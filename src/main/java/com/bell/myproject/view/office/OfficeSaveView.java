package com.bell.myproject.view.office;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "класс для сохранения оффиса")
public class OfficeSaveView {
    @ApiModelProperty(required = true, value = "id организации, которой принадлежит оффис")
    @NotNull(message = "Задайте orgId")
    private Integer orgId;
    @ApiModelProperty(value = "имя оффиса")
    private String name;
    @ApiModelProperty(value = "аддресс оффиса")
    private String address;
    @ApiModelProperty(value = "телефон оффиса")
    private String phone;
    @ApiModelProperty(value = "статус активности оффиса")
    private Boolean isActive;
}
