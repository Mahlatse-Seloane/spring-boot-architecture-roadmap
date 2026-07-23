package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import java.util.List;
import java.util.Optional;

public interface EmployeeService
{
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    Optional<EmployeeDto> getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    Optional<EmployeeDto> updateEmployee(Long id, EmployeeDto updatedEmployee);

    boolean deleteEmployee(Long id);
}
