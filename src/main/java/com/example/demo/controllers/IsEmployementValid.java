package com.example.demo.controllers;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = EmploymentTypeValidator.class)
@Target( { TYPE, METHOD, PARAMETER, FIELD } )  
@Retention(RetentionPolicy.RUNTIME)  
public @interface IsEmployementValid {

	public String message() default "{employeeTypeInvalid}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
