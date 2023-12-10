package com.ems.employeemanagement.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateSubOrganizationRequest {

    @NotNull
    private String subOrganizationName;
    @NotNull
    private Long organizationId;

}
