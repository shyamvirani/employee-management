package com.ems.employeemanagement.service;

import com.ems.employeemanagement.dto.CreateOrganizationRequest;
import com.ems.employeemanagement.entitiy.Organization;
import com.ems.employeemanagement.entitiy.SubOrganization;

public interface OrganizationService {

    void createOrganization(CreateOrganizationRequest createOrganizationRequest);

    Organization getOrganizationById(Long organizationId);

}
