package com.rest.rest.service.impl;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee updatEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "id", id)
        );
        // Note: this is equivalent to
        //
        // Optional.ofNullable(updatedEmployee.getFirstName()).ifPresent(firstName -> existingEmployee.setFirstName(firstName));
        Optional.ofNullable(employee.getFirstName()).ifPresent(existingEmployee::setFirstName);
        Optional.ofNullable(employee.getLastName()).ifPresent(existingEmployee::setLastName);
        Optional.ofNullable(employee.getEmail()).ifPresent(existingEmployee::setEmail);

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }
}
