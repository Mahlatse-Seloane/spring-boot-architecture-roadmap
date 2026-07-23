package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService
{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long id)
    {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public List<EmployeeDto> getAllEmployees()
    {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDto> updateEmployee(Long id, EmployeeDto updatedEmployee)
    {
        return employeeRepository.findById(id)
                .map(employee ->
                {
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setEmail(updatedEmployee.getEmail());

                    Employee savedEmployee = employeeRepository.save(employee);
                    return EmployeeMapper.mapToEmployeeDto(savedEmployee);
                });
    }

    @Override
    public boolean deleteEmployee(Long id)
    {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employeeRepository.delete(employee);
                    return true;
                })
                .orElse(false);
    }
}
