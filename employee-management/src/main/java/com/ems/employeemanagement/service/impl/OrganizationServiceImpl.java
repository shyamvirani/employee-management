package com.ems.employeemanagement.service.impl;

import com.ems.employeemanagement.dto.CreateOrganizationRequest;
import com.ems.employeemanagement.entitiy.Organization;
import com.ems.employeemanagement.repository.OrganizationRepository;
import com.ems.employeemanagement.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;


    @Override
    public void createOrganization(CreateOrganizationRequest createOrganizationRequest) {
        Organization organization = new Organization();
        organization.setOrganizationName(createOrganizationRequest.getOrganizationName());
        organizationRepository.save(organization);
    }

    @Override
    public Organization getOrganizationById(Long organizationId) {
        return organizationRepository.findById(organizationId).orElse(null);
    }
}
