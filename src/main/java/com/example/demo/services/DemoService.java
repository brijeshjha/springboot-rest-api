package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class DemoService {

  @Autowired
  EmployeeRepository repo;	
	
  public void insertEmployee(Employee emp) {
	  repo.save(emp);
  }
  
  public List<Employee> getAllEmployeeByType(String empType){
	  return repo.getEmployeesByType(empType);
  }
}
