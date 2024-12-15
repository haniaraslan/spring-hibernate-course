package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService){ // constructor injection
		this.employeeService = employeeService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		// return the employees list page
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){

		// create model attribute to bind form data
		Employee employee = new Employee();

		// thymeleaf access this data for binding form data
		model.addAttribute("employee", employee);

		// return the form html page
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){

		employeeService.save(employee);

		// return the employees list page
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){

		// get the employee from the service
		Employee employee = employeeService.findById(id);

		// thymeleaf access this data for binding form data
		model.addAttribute("employee", employee);

		// return the form html page
		return "employees/employee-form";
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id){

		employeeService.deleteById(id);
		// get the employee from the service
		List<Employee> employee = employeeService.findAll();

		// return the employees list page
		return "redirect:/employees/list";
	}
}









