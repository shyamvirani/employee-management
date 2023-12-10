package com.ems.employeemanagement.entitiy;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "organization_name")
    private String organizationName;
}
