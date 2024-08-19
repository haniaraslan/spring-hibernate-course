package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface EmployeeRestController extends JpaRepository<Employee, Integer> {
}
