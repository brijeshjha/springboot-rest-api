package com.example.demo.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;

@RestController
@RequestMapping(value = "/v1")
@Validated
public class DemoController {

	Logger logger = LogManager.getLogger(DemoController.class);

	@PostMapping("/validate")
	public void validateEmployee(@Valid @RequestBody Employee emp) {
		logger.info(emp);
	}

}
