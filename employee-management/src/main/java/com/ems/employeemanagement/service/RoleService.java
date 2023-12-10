package com.ems.employeemanagement.service;

import com.ems.employeemanagement.dto.CreateRoleRequest;
import com.ems.employeemanagement.entitiy.Role;
import com.ems.employeemanagement.exception.CommonException;

public interface RoleService {

    void createRole(CreateRoleRequest createRoleRequest);

    Role getRoleById(Long roleId);

    void deleteRole(Long roleId) throws CommonException;

}
