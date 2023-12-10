package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.dto.CreateOrganizationRequest;
import com.ems.employeemanagement.rest.RestResponse;
import com.ems.employeemanagement.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public RestResponse createOrganization(@RequestBody CreateOrganizationRequest createOrganizationRequest){
        RestResponse restResponse = new RestResponse();
        organizationService.createOrganization(createOrganizationRequest);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }
}
