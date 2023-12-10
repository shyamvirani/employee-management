package com.ems.employeemanagement.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateDepartmentRequest {

    private Long id;

    @NotNull
    private String departmentName;

}
