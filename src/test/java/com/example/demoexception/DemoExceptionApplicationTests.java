package com.example.demoexception;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.exceptions.ResourceNotFoundException;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DemoExceptionApplicationTests {

	

	@Autowired
	private StudentService stuService;
	
	StudentPOJO student=new StudentPOJO();
	
	
	@Test
	void contextLoads() {
	}

	@Order(1)
	@Test
	public void addStudent() {
		student.setId(1);
		student.setName("delphina");
		student.setMno(3465325423L);
		student.setAddress("Chennai");
		//assertThat(stuService.addStudent(student).equals("Student Records saved successfully.."));
		assertTrue(stuService.addStudent(student));
		
		//checks the Invalid input...
		//StudentPOJO nullStudent=new StudentPOJO();
		//assertThat(stuService.addStudent(nullStudent).equals("Please Enter the Value"));
		//assertFalse(stuService.addStudent(nullStudent));
		
	}
	
	
	@Order(2)
	@Test
	public void fetchStudent() {
		assertNotNull(stuService.fetchStudent(1));
		assertNull(stuService.fetchStudent(100));
		
	}
	
	@Order(3)
	@Test
	public void fetchAllStudent() {
		assertNotNull(stuService.fetchAllStudent());
		
	}
	
	@Order(4)
	@Test
	public void updateStudent() {
		student.setId(1);
		student.setName("felix");
		student.setMno(3465325423L);
		student.setAddress("salem");
		assertNotNull(stuService.updateStudent(student));
		
		StudentPOJO stu=new StudentPOJO();
		assertNull(stuService.updateStudent(stu));
	}
	
	@Order(5)
	@Test
	public void deleteStudent()  {
		assertThat(stuService.deleteStudent(1).equals("student deleted successfully.."));
		assertThat(stuService.deleteStudent(100).equals("Resource Not Found"));
	}
	
	@Order(6)
	@Test
	public void fetchAddresses() {
		assertNotNull(stuService.fetchAddress());
	}
}
