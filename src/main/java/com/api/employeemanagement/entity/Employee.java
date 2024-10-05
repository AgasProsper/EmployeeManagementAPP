package com.api.employeemanagement.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Paul Nyishar
 * Web Applications Developer
 * @Date 24/07/2022
 */
@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
