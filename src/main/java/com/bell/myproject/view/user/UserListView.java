package com.bell.myproject.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс для списка юзеров")
public class UserListView{
    @ApiModelProperty(value = "id юзера")
    private Integer id;
    @ApiModelProperty(value = "имя юзера")
    private String firstName;
    @ApiModelProperty(value = "фамилия юзера")
    private String secondName;
    @ApiModelProperty(value = "отчество юзера")
    private String middleName;
    @ApiModelProperty(value = "должность юзера")
    private String position;
}
