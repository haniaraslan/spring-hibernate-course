package com.luv2code.springboot.cruddemo.services;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDAO employeeDAO;

    EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public Employee getEmployeeByID(int Id) {
        return employeeDAO.getEmployeeByID(Id);
    }

    @Override
    @Transactional
    public void deleteAllEmployees() {
        employeeDAO.deleteAllEmployees();
    }

    @Override
    @Transactional
    public void deleteEmployeeByID(int Id) {
        employeeDAO.deleteEmployeeByID(Id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

}
