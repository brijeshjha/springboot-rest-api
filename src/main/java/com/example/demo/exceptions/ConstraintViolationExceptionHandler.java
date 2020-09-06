package com.example.demo.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.entities.Error;
import com.example.demo.entities.Errors;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class ConstraintViolationExceptionHandler {

	Errors errors = new Errors();
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Errors> handleExceptions(MethodArgumentNotValidException e) {
		List<Error> errorList = new ArrayList<Error>();
		e.getBindingResult().getAllErrors().forEach(error->{
			String fieldname = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			Error inputError = new Error(HttpStatus.BAD_REQUEST.value(),message);
			errorList.add(inputError);
		});
		errors.setErrors(errorList);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	/*@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<Errors> handleExceptions(InvalidFormatException e) {
		List<Error> errorList = new ArrayList<Error>();
		Error error = new Error(HttpStatus.BAD_REQUEST.value(),e.getValue().toString()+" is of Invalid Type");
		errorList.add(error);
		errors.setErrors(errorList);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	*/

	
}
