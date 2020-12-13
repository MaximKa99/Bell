package com.bell.myproject.view.organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationFilterView {
    @NotEmpty(message = "Нужно задать имя организации!!!")
    private String name;
    @Size(max = 12, message = "некорректная длина инн. Максимум 12")
    private String inn;
    private Boolean isActive;
}
