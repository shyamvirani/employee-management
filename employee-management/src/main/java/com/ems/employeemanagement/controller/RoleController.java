package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.dto.CreateRoleRequest;
import com.ems.employeemanagement.entitiy.Role;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.rest.RestResponse;
import com.ems.employeemanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;

    @PostMapping
    public RestResponse createRole(@RequestBody CreateRoleRequest createRoleRequest){
        RestResponse restResponse = new RestResponse();
        roleService.createRole(createRoleRequest);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @GetMapping("/{roleId}")
    public RestResponse getRoleById(@PathVariable(value = "roleId") long roleId){
        RestResponse restResponse = new RestResponse();
        Role role = roleService.getRoleById(roleId);
        restResponse.setResponseData(role);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @DeleteMapping("/{roleId}")
    public RestResponse deleteRoleById(@PathVariable(value = "roleId") long roleId) throws CommonException {
        RestResponse restResponse = new RestResponse();
        roleService.deleteRole(roleId);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @PutMapping
    public RestResponse updateRole(@RequestBody CreateRoleRequest createRoleRequest){
        RestResponse restResponse = new RestResponse();
        roleService.createRole(createRoleRequest);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }
}
