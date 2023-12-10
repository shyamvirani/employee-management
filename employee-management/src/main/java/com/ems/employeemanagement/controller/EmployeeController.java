package com.ems.employeemanagement.controller;

import com.ems.employeemanagement.dto.CreateEmployeeRequest;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.rest.RestResponse;
import com.ems.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public RestResponse createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) throws CommonException {
        RestResponse restResponse = new RestResponse();
        employeeService.createEmployee(createEmployeeRequest);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @GetMapping("/{employeeId}")
    public RestResponse getEmployeeById(@PathVariable(value = "employeeId") long employeeId) {
        RestResponse restResponse = new RestResponse();
        Employee employee = employeeService.getEmployeeById(employeeId);
        restResponse.setResponseData(employee);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @DeleteMapping("/{employeeId}")
    public RestResponse deleteEmployeeById(@PathVariable(value = "employeeId") long employeeId) throws Exception {
        RestResponse restResponse = new RestResponse();
        employeeService.deleteEmployee(employeeId);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }

    @PutMapping
    public RestResponse updateEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) throws CommonException {
        RestResponse restResponse = new RestResponse();
        employeeService.createEmployee(createEmployeeRequest);
        restResponse.setResponseData(null);
        restResponse.getMetadata().setSuccessOutcome();
        return restResponse;
    }


}
