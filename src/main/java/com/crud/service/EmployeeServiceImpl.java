package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.crud.dao.EmployeeRepo;
import com.crud.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalemployee= employeeRepo.findById((int) id);
		Employee employee=null;
		if(optionalemployee.isPresent())
		{
			employee=optionalemployee.get();
			
		}
		else {
			throw new RuntimeException("Employee not found for id:"+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		this.employeeRepo.deleteById(id);
	}

	@Override
	public void updateEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.employeeRepo.findById((int) id);
		
		
		
	}

	@Override
		public List<Employee> searchEmployeeByName(@Param("name") String name) {
		
		return this.employeeRepo.findEmployeeByName(name);
	}

}
