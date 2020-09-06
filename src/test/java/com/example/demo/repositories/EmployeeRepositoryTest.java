package com.example.demo.repositories;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.entities.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	TestEntityManager em;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Test
	public void testForEmployeeTypeContract() {
		Employee emp = insertEmployee();
		List<Employee> empList = empRepo.getEmployeesByType("Contract");
		assertThat(empList.get(0),Matchers.is(emp));
	}

	private Employee insertEmployee() {
	   Employee emp = new Employee();
	   emp.setName("raj");
	   emp.setAge(20);
	   emp.setEmploymentType("Contract");
	   em.persist(emp);
	   return emp;
	}
	
}
