package com.example.demo.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.demo.controllers.IsEmployementValid;

public class Employee {

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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}
