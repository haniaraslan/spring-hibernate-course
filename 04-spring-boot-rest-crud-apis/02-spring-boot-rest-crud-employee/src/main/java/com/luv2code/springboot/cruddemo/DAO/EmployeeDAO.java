package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.Entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAllEmployees();
    Employee getEmployeeByID(int Id);
    void deleteAllEmployees();
    void deleteEmployeeByID(int Id);
    Employee save(Employee employee);


}

