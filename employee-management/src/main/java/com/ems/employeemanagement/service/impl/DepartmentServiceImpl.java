package com.ems.employeemanagement.service.impl;

import com.ems.employeemanagement.dto.CreateDepartmentRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.repository.DepartmentRepository;
import com.ems.employeemanagement.service.DepartmentService;
import com.ems.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void createDepartment(CreateDepartmentRequest createDepartmentRequest) throws CommonException {
        if (createDepartmentRequest.getId() != null) {
            Optional<Department> departmentOptional = departmentRepository.findById(createDepartmentRequest.getId());
            if (departmentOptional.isPresent()) {
                Department department = departmentOptional.get();
                department.setDepartmentName(createDepartmentRequest.getDepartmentName());
                departmentRepository.save(department);
            } else {
                log.error("Department with id {} not found ", createDepartmentRequest.getId());
                throw new CommonException("Department not found with id " + createDepartmentRequest.getId());
            }
        } else {
            Department department = new Department();
            department.setDepartmentName(createDepartmentRequest.getDepartmentName());
            departmentRepository.save(department);
        }
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public void deleteDepartment(Long departmentId) throws CommonException {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            List<Employee> employees = employeeService.findByDepartment(department);
            if (employees.isEmpty()) {
                departmentRepository.deleteById(departmentId);
            } else {
                throw new CommonException("Department cannot be deleted as employee(s) are asscoated with this department");
            }
        } else {
            log.error("Department with id {} not found ", departmentId);
        }
    }
}
