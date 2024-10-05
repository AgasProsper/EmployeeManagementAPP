package com.api.employeemanagement.service;

import com.api.employeemanagement.dto.EmployeeDto;

import java.util.List;

/**
 * @author Paul Nyishar
 * Web Applications Developer
 * @Date 24/07/2022
 */
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    boolean deleteEmployee(Long id);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
}
