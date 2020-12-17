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
public class OfficeIdView{
    @ApiModelProperty()
    private Integer id;
    private int orgId;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;
}
