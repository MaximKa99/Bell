package com.bell.myproject.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс для списка оффисов")
public class OfficeListView {
    @ApiModelProperty(value = "id оффиса")
    private Integer id;
    @ApiModelProperty(value = "имя оффиса")
    private String name;
    @ApiModelProperty(value = "статус оффиса")
    private Boolean isActive;
}
