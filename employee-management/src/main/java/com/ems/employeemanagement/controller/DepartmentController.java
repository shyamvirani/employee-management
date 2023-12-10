package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.dto.CreateDepartmentRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.rest.RestResponse;
import com.ems.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping
    public RestResponse createDepartment(@RequestBody CreateDepartmentRequest createDepartmentRequest) throws CommonException {
        RestResponse restResponse = new RestResponse();
        departmentService.createDepartment(createDepartmentRequest);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @GetMapping("/{departmentId}")
    public RestResponse getDepartmentById(@PathVariable(value = "departmentId") long departmentId){
        RestResponse restResponse = new RestResponse();
        Department department = departmentService.getDepartmentById(departmentId);
        restResponse.setResponseData(department);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @DeleteMapping("/{departmentId}")
    public RestResponse deleteDepartmentById(@PathVariable(value = "departmentId") long departmentId) throws CommonException {
        RestResponse restResponse = new RestResponse();
        departmentService.deleteDepartment(departmentId);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @PutMapping
    public RestResponse updateDepartment(@RequestBody CreateDepartmentRequest createDepartmentRequest) throws CommonException {
        RestResponse restResponse = new RestResponse();
        departmentService.createDepartment(createDepartmentRequest);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }
}
