package com.bell.myproject.view.organization;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationFilter {
    @NotEmpty(message = "Нужно задать имя организации!!!")
    private String name;
    private String inn;
    private Boolean isActive;
}
