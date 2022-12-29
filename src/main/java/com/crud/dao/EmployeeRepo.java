package com.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.crud.model.Employee;


public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	
	@Modifying
	@Query(value="select * from emp_details e where e.name=?1",nativeQuery=true)     
    List<Employee> findEmployeeByName(String name);
}
