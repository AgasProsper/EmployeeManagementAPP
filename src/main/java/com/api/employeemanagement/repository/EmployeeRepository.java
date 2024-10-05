package com.api.employeemanagement.repository;

import com.api.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Paul Nyishar
 * Web Applications Developer
 * @Date 24/07/2022
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
