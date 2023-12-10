package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.dto.CreateOrganizationRequest;
import com.ems.employeemanagement.dto.CreateSubOrganizationRequest;
import com.ems.employeemanagement.rest.RestResponse;
import com.ems.employeemanagement.service.OrganizationService;
import com.ems.employeemanagement.service.SubOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sub-organization")
public class SubOrganizationController {

    @Autowired
    private SubOrganizationService subOrganizationService;

    @PostMapping
    public RestResponse createSubOrganization(@RequestBody CreateSubOrganizationRequest createSubOrganizationRequest) {
        RestResponse restResponse = new RestResponse();
        subOrganizationService.createSubOrganization(createSubOrganizationRequest);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

}
