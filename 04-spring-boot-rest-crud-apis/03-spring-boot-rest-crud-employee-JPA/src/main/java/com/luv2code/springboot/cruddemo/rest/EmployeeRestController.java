package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.Entity.Employee;
import com.luv2code.springboot.cruddemo.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
  //  private EmployeeDAO employeeDAO;
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> GetAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee GetEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeByID(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee Id Not Found! - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee AddEmployeeById(@RequestBody Employee employee){
        employee.setId(0);
        Employee newEmployee = employeeService.save(employee);
        return newEmployee;
    }

    @PutMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String saveEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeByID(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee Id not found! " + employeeId);
        }

        employeeService.deleteEmployeeByID(employeeId);
        
        return "Employee Deleted Successfully";
    }


}
