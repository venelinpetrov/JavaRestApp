package com.rest.rest.service;

import java.util.List;

import com.rest.rest.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updatEmployee(Employee employee, long id);
}
