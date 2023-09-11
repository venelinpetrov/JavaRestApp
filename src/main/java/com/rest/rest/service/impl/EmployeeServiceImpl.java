package com.rest.rest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.rest.exception.ResourceNotFoundException;
import com.rest.rest.model.Employee;
import com.rest.rest.repository.EmployeeRepository;
import com.rest.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }
}
