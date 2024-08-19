package com.luv2code.springboot.cruddemo.services;

import com.luv2code.springboot.cruddemo.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    Employee getEmployeeByID(int Id);
    void deleteAllEmployees();
    void deleteEmployeeByID(int Id);
    Employee save(Employee employee);
}

