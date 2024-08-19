package com.luv2code.springboot.cruddemo.services;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(int Id) {
        Optional<Employee> result = employeeRepository.findById(Id);

        Employee employee = null;
        if(result.isPresent()) {
            employee = result.get();
        }
        else {
            throw new RuntimeException("Employee Id Not Found! " + Id);
        }
        return employee;
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteEmployeeByID(int Id) {
        employeeRepository.deleteById(Id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

}
