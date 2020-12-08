package com.bell.myproject.view.office;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeFilterView {
    @NotNull(message = "Задайте orgId")
    private Integer orgId;
    private String name;
    private String phone;
    private Boolean isActive;
}