package com.bell.myproject.view.office;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeSave {
    @Min(value = 1 ,message = "Задайте orgId")
    private int orgId;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;
}
