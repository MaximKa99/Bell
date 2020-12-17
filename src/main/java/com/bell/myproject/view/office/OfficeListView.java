package com.bell.myproject.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class OfficeListView {
    @ApiModelProperty()
    private Integer id;
    private String name;
    private Boolean isActive;
}
