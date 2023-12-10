package com.ems.employeemanagement.repository;

import com.ems.employeemanagement.entitiy.Organization;
import com.ems.employeemanagement.entitiy.SubOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOrganizationRepository extends JpaRepository<SubOrganization,Long> {
}
