package com.crud.service;

import java.util.List;

import org.springframework.ui.Model;

import com.crud.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(int id);
	void updateEmployeeById(long id);
	List<Employee> searchEmployeeByName(String name);
	
	
}
