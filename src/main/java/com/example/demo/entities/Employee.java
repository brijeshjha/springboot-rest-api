package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.demo.controllers.IsEmployementValid;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int empid;
	
	@NotBlank(message = "{nameInvalid}")
	private String name;
	
	@Min(value=18, message="{ageInvalid}")
	private int age;
	
	private int salary;

	@NotBlank(message = "Invalid Employment")
	@IsEmployementValid
	private String employmentType;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", age=" + age + ", salary=" + salary
				+ ", employmentType=" + employmentType + "]";
	}

}
