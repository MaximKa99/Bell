package com.bell.myproject.view.organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Фильтер-класс для фильтрации организаций")
public class OrganizationFilterView {
    @ApiModelProperty(required = true, value = "имя организации")
    @NotEmpty(message = "Нужно задать имя организации!!!")
    private String name;
    @ApiModelProperty(value = "инн организации")
    @Size(max = 12, message = "некорректная длина инн. Максимум 12")
    private String inn;
    @ApiModelProperty(value = "Статус активности организаци")
    private Boolean isActive;
}
