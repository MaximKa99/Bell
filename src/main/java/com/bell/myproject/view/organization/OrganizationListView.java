package com.bell.myproject.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class OrganizationListView{
    @ApiModelProperty()
    private Integer id;
    private String name;
    private Boolean isActive;
}
