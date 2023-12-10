package com.ems.employeemanagement.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateRoleRequest {

    private Long id;

    @NotNull
    private String roleName;

    @NotNull
    private String roleDescription;
}

