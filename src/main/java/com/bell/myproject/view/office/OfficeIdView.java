package com.bell.myproject.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс для офиса, взятого пол id")
public class OfficeIdView{
    @ApiModelProperty(value = "id оффиса")
    private Integer id;
    @ApiModelProperty(value = "id организации, которая владеет офисом")
    private int orgId;
    @ApiModelProperty(value = "имя оффиса")
    private String name;
    @ApiModelProperty(value = "аддресс офиса")
    private String address;
    @ApiModelProperty(value = "телефон юзера")
    private String phone;
    @ApiModelProperty(value = "статус оффиса")
    private Boolean isActive;
}
