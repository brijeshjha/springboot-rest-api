package com.example.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.demo.configfiles.EmployeeConfiguration;
import com.example.demo.exceptions.ConstraintViolationExceptionHandler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmployeeConfiguration.class})
public class DemoControllerTest {

	@InjectMocks
	DemoController controller;
	
	@InjectMocks
	ConstraintViolationExceptionHandler exceptionHandler;
	
	@InjectMocks
	EmployeeConfiguration emp;
	
	MockMvc mockMvc;
	
	@Before
	public void initialize() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(exceptionHandler).setValidator(emp.getValidator()).build();
	}

	@Test
	public void testIfNameIsNotBlankReturnSuccess() throws Exception {
		String content = "{\r\n" + "	\"name\" : \"brijesh\",\r\n" + "	\"age\" : \"20\",\r\n"
				+ "	\"salary\" : 1000\r\n" + "}";
		mockMvc.perform(post("/v1/validate").contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testIfNameIsBlankThrowError() throws Exception {
		String content = "{\r\n" + "	\"name\" : \"\",\r\n" + "	\"age\" : \"20\",\r\n"
				+ "	\"salary\" : 1000\r\n" + "}"; 
		mockMvc.perform(post("/v1/validate").contentType(MediaType.APPLICATION_JSON).content(content))
		.andExpect(status().is(400))
		.andExpect(jsonPath("$.errors[0].message", Matchers.is("name should not be blank")));
	}

}
