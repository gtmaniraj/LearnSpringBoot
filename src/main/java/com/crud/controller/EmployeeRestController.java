package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;

@RestController
@RequestMapping("/restCon")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/index")
	public List<Employee> viewHomePage() {
		List<Employee> emplist = employeeService.getAllEmployee();
		
		return emplist;
	}

	@PostMapping("/save")
	public String Save(@ModelAttribute("employee") Employee employee) {
//		System.out.println(employee);
		employeeService.saveEmployee(employee);	
		return employee.toString()+" has been saved";
	}
//	
	@PostMapping("/delete/{id}")
	public String Delete(@PathVariable("id") int id) {
//		System.out.println(id+"=id");

		employeeService.deleteEmployeeById(id);
//		
		return "Employee having id= "+ id + " has been deleted";
	}
	@PostMapping("/update")
	public String Update(@ModelAttribute("employee") Employee employee) {	
		employeeService.saveEmployee(employee);
		
		return employee.toString()+" has been updated";
	}
//	
	@PostMapping("/search")
	public String Search(String name) {
//		System.out.println(name+"=name");
		employeeService.searchEmployeeByName(name);

		return employeeService.searchEmployeeByName(name) + " has been searched";
	}

}
