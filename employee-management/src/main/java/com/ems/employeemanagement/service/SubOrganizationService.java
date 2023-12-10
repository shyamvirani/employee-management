package com.ems.employeemanagement.service;

import com.ems.employeemanagement.dto.CreateOrganizationRequest;
import com.ems.employeemanagement.dto.CreateSubOrganizationRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.entitiy.SubOrganization;

public interface SubOrganizationService {

    void createSubOrganization(CreateSubOrganizationRequest createSubOrganizationRequest);

    SubOrganization getSubOrganizationById(Long subOrganizationId);

}
