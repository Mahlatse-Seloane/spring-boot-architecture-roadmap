package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController
{
    private final List<Employee> employees = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        List<EmployeeDto> employeesDto = employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(employeesDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id)
    {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .map(employee -> {
                    EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
                    return ResponseEntity.ok().body(employeeDto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody EmployeeDto employeeDto)
    {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employee.setId(nextId++);
        employees.add(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto updatedEmployee)
    {
        return employees.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .map(employee ->
                {
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setEmail(updatedEmployee.getEmail());

                    EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);
                    return ResponseEntity.ok(savedEmployeeDto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id)
    {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .map(employee ->
                {
                    employees.remove(employee);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}