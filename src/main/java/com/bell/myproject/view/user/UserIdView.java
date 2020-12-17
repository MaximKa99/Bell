package com.bell.myproject.view.user;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UserIdView{
    @ApiModelProperty()
    private Integer id;
    private int officeId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private String docName;
    private String docNumber;
    private int docCode;
    private Date docDate;
    private int citizenshipCode;
    private String citizenshipName;
    private Boolean isIdentified;
}
