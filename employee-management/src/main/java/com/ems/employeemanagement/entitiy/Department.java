package com.ems.employeemanagement.entitiy;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "department")
public class Department {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="department_name")
    private String departmentName;

}
