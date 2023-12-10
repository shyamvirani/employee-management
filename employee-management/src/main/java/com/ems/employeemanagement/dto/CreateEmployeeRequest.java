package com.ems.employeemanagement.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CreateEmployeeRequest {

    private Long id;

    @NotEmpty(message = "The first name is required.")
    @NotNull
    private String firstName;

    @NotEmpty(message = "The last name is required.")
    @NotNull
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be of 10 digit")
    private String mobileNo;

    @Min(value = 18, message = "The age must be greater than 18")
    private Integer age;

    @NotNull
    private Long subOrganizationId;

    @NotNull
    private Long departmentId;

    @NotNull
    private Long roleId;
}

