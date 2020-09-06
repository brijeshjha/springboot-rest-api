package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.services.DemoService;

@RestController
@RequestMapping(value = "/v1")
@Validated
public class DemoController {

	Logger logger = LogManager.getLogger(DemoController.class);

	@Autowired
	DemoService service;

	@PostMapping("/employee")
	public void insertEmployee(@Valid @RequestBody Employee emp) {
		logger.info(emp);
		service.insertEmployee(emp);
	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployeeByType(@RequestParam("typeOfEmployee") @IsEmployementValid String typeOfEmployee) {
      return ResponseEntity.status(HttpStatus.OK).body(service.getAllEmployeeByType(typeOfEmployee));
	}

}
