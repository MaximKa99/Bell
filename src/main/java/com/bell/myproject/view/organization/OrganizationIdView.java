package com.bell.myproject.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class OrganizationIdView{
    @ApiModelProperty()
    private Integer id;
    private String name;
    private String fullName;
    private String address;
    private String inn;
    private String kpp;
    private String phone;
    private Boolean isActive;
}
