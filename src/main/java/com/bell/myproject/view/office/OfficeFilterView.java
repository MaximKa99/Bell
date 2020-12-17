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
@ApiModel(description = "Фильтр-класс для фильтрации оффисов")
public class OfficeFilterView {
    @ApiModelProperty(required = true, value = "id организации, которой принадлежит оффис")
    @NotNull(message = "Задайте orgId")
    private Integer orgId;
    @ApiModelProperty(value = "фильтрация по имени оффиса")
    private String name;
    @ApiModelProperty(value = "фильтрация по телефону оффиса")
    private String phone;
    @ApiModelProperty(value = "фильтрация по статусу активности оффиса")
    private Boolean isActive;
}
