package com.bell.myproject.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserListView{
    @ApiModelProperty()
    private Integer id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
}
