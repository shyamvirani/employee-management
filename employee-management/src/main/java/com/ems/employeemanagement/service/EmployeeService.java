package com.ems.employeemanagement.service;

import com.ems.employeemanagement.dto.CreateEmployeeRequest;
import com.ems.employeemanagement.dto.CreateSubOrganizationRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.entitiy.Role;
import com.ems.employeemanagement.exception.CommonException;

import java.util.List;

public interface EmployeeService {

    void createEmployee(CreateEmployeeRequest createEmployeeRequest) throws CommonException;

    Employee getEmployeeById(Long employeeId);

    void deleteEmployee(Long employeeId);

    List<Employee> findByRole(Role role);

    List<Employee> findByDepartment(Department department);

}
