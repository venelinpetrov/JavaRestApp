package com.rest.rest.service;

import java.util.List;

import com.rest.rest.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
