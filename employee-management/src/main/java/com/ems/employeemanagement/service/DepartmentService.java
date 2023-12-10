package com.ems.employeemanagement.service;

import com.ems.employeemanagement.dto.CreateDepartmentRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.exception.CommonException;

public interface DepartmentService {

    void createDepartment(CreateDepartmentRequest createDepartmentRequest) throws CommonException;

    Department getDepartmentById(Long departmentId);

    void deleteDepartment(Long departmentId) throws CommonException;
}
