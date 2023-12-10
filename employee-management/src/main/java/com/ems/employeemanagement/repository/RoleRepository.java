package com.ems.employeemanagement.repository;

import com.ems.employeemanagement.entitiy.Organization;
import com.ems.employeemanagement.entitiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
