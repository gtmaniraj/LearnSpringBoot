package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;

@Controller
@RequestMapping("/con")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/index")
	public String viewHomePage(Model model) {
		List<Employee> emplist = employeeService.getAllEmployee();
		model.addAttribute("model",emplist);
		return "index";
	}

	@PostMapping("/save")
	public String Save(@ModelAttribute("employee") Employee employee,Model model) {
		System.out.println(employee);
		employeeService.saveEmployee(employee);
		List<Employee> emplist = employeeService.getAllEmployee();
		model.addAttribute("model",emplist);
		System.out.println(employee);
		
		return "index";
	}
	
	@PostMapping("/delete/{id}")
	public String Delete(@ModelAttribute("employee") Employee employee, @PathVariable("id") int id,Model model) {
		System.out.println(id+"=id");
		employeeService.deleteEmployeeById(id);
		List<Employee> emplist = employeeService.getAllEmployee();
		model.addAttribute("model",emplist);
		return "index";
	}
	@PostMapping("/update")
	public String Update(@ModelAttribute("employee") Employee employee, Model model) {	
		employeeService.saveEmployee(employee);
		List<Employee> emplist = employeeService.getAllEmployee();
		model.addAttribute("model",emplist);
		
		return "index";
	}
	
	@PostMapping("/search")
	public String Search(String name,Model model) {
		System.out.println(name+"=name");
		List<Employee> emplist= employeeService.searchEmployeeByName(name);
		 System.out.println("emplist="+emplist);
		model.addAttribute("model",emplist);
		return "index";
	}

}