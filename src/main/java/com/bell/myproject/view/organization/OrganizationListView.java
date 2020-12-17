package com.bell.myproject.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс для списка организаций")
public class OrganizationListView{
    @ApiModelProperty(value = "id организации")
    private Integer id;
    @ApiModelProperty(value = "имя организации")
    private String name;
    @ApiModelProperty(value = "статус организации")
    private Boolean isActive;
}
