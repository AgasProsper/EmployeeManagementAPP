package com.api.employeemanagement.controller;

import com.api.employeemanagement.dto.EmployeeDto;
import com.api.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Value("${frontend.ip}") // Inject the IP address from application properties or environment
    private String frontendIp;

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @CrossOrigin(origins = "${frontend.ip}") // Use the injected IP for CORS
    @PostMapping("employees")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "${frontend.ip}")
    @GetMapping("employees")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @CrossOrigin(origins = "${frontend.ip}")
    @DeleteMapping("employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "${frontend.ip}")
    @GetMapping("employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @CrossOrigin(origins = "${frontend.ip}")
    @PutMapping("employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        employeeDto = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto);
    }
}
