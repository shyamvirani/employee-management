package com.ems.employeemanagement.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateOrganizationRequest {

    @NotNull
    private String organizationName;

}
