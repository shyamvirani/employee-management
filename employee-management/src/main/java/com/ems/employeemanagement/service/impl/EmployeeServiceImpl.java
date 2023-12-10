package com.ems.employeemanagement.service.impl;

import com.ems.employeemanagement.dto.CreateEmployeeRequest;
import com.ems.employeemanagement.entitiy.Department;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.entitiy.Role;
import com.ems.employeemanagement.entitiy.SubOrganization;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.repository.EmployeeRepository;
import com.ems.employeemanagement.service.DepartmentService;
import com.ems.employeemanagement.service.EmployeeService;
import com.ems.employeemanagement.service.RoleService;
import com.ems.employeemanagement.service.SubOrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SubOrganizationService subOrganizationService;

    @Autowired
    private RoleService roleService;

    @Override
    public void createEmployee(CreateEmployeeRequest createEmployeeRequest) throws CommonException {
        Employee employee = new Employee();
        if (createEmployeeRequest.getId() != null) {
            Optional<Employee> employeeOptional = employeeRepository.findById(createEmployeeRequest.getId());
            if (employeeOptional.isPresent()) {
                employee = employeeOptional.get();
            } else {
                log.error("Employee with id {} not found ", createEmployeeRequest.getId());
                return;
            }
        }
        BeanUtils.copyProperties(createEmployeeRequest, employee);
        Department department = departmentService.getDepartmentById(createEmployeeRequest.getDepartmentId());
        if (department == null)
            throw new CommonException("Department not found with id " + createEmployeeRequest.getDepartmentId());
        employee.setDepartment(department);
        SubOrganization subOrganization = subOrganizationService.getSubOrganizationById(createEmployeeRequest.getSubOrganizationId());
        if (subOrganization == null)
            throw new CommonException("SubOrganization not found with id " + createEmployeeRequest.getSubOrganizationId());
        employee.setSubOrganization(subOrganization);
        Role role = roleService.getRoleById(createEmployeeRequest.getRoleId());
        if (role == null)
            throw new CommonException("Role not found with id " + createEmployeeRequest.getRoleId());
        employee.setRole(role);
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = getEmployeeById(employeeId);
        if (employee != null) {
            employeeRepository.deleteById(employeeId);
        } else {
            log.error("Employee with id {} not found ", employeeId);
        }
    }

    @Override
    public List<Employee> findByRole(Role role) {
        return employeeRepository.findByRole(role);
    }

    @Override
    public List<Employee> findByDepartment(Department department) {
        return employeeRepository.findByDepartment(department);
    }
}

