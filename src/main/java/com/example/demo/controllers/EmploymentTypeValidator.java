package com.example.demo.controllers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmploymentTypeValidator implements ConstraintValidator<IsEmployementValid,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.matches("Permanent | Contract")) {
		  return true;	
		}
		return false;
	}

}
