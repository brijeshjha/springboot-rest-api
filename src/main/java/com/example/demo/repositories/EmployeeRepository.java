package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("from Employee e where e.employmentType = ?1")
	public List<Employee> getEmployeesByType(String typeOfEmployee);
	
}
