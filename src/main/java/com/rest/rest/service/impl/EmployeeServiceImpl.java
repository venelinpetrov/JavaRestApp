package com.rest.rest.service.impl;

import org.springframework.stereotype.Service;

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

}
