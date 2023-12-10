package com.ems.employeemanagement.service.impl;

import com.ems.employeemanagement.dto.CreateSubOrganizationRequest;
import com.ems.employeemanagement.entitiy.Organization;
import com.ems.employeemanagement.entitiy.SubOrganization;
import com.ems.employeemanagement.repository.OrganizationRepository;
import com.ems.employeemanagement.repository.SubOrganizationRepository;
import com.ems.employeemanagement.service.OrganizationService;
import com.ems.employeemanagement.service.SubOrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SubOrganizationServiceImpl implements SubOrganizationService {

    @Autowired
    private SubOrganizationRepository subOrganizationRepository;

    @Autowired
    private OrganizationService organizationService;

    @Override
    public void createSubOrganization(CreateSubOrganizationRequest createSubOrganizationRequest) {
        SubOrganization subOrganization = new SubOrganization();
        Organization organization = organizationService.getOrganizationById(createSubOrganizationRequest.getOrganizationId());
        subOrganization.setSubOrganizationName(createSubOrganizationRequest.getSubOrganizationName());
        subOrganization.setOrganization(organization);
        subOrganizationRepository.save(subOrganization);
    }

    @Override
    public SubOrganization getSubOrganizationById(Long subOrganizationId) {
        return subOrganizationRepository.findById(subOrganizationId).orElse(null);
    }
}
