package com.ems.employeemanagement.service.impl;

import com.ems.employeemanagement.dto.CreateRoleRequest;
import com.ems.employeemanagement.entitiy.Employee;
import com.ems.employeemanagement.entitiy.Role;
import com.ems.employeemanagement.exception.CommonException;
import com.ems.employeemanagement.repository.RoleRepository;
import com.ems.employeemanagement.service.EmployeeService;
import com.ems.employeemanagement.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void createRole(CreateRoleRequest createRoleRequest) {
        Role role = new Role();
        if (createRoleRequest.getId() != null) {
            Optional<Role> roleOptional = roleRepository.findById(createRoleRequest.getId());
            if (roleOptional.isPresent()) {
                role = roleOptional.get();
            } else {
                log.error("Role with id {} not found ", createRoleRequest.getId());
                return;
            }
        }
        role.setRoleName(createRoleRequest.getRoleName());
        role.setRoleDescription(createRoleRequest.getRoleDescription());
        roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public void deleteRole(Long roleId) throws CommonException {
        Role role = getRoleById(roleId);
        if (role != null) {
            List<Employee> employees = employeeService.findByRole(role);
            if (!employees.isEmpty())
                throw new CommonException("Role can not be deleted as employee(s) are associated this role");
            roleRepository.deleteById(roleId);
        } else {
            throw new CommonException("Role not found with role id " + roleId);
        }
    }
}
