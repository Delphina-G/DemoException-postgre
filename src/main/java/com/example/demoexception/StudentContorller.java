package com.example.demoexception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class StudentContorller {
	
	@Autowired
	private StudentService stuService;
	
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody StudentPOJO student) {

		if(stuService.addStudent(student)) {
			return "Student Record saved successfully...";
		}
		else {
			return "Could not save student record";
		}
		
	}
	
	@GetMapping("/fetchStudent/{id}")
	public StudentPOJO fetchStudent(@PathVariable Integer id) {
		StudentPOJO student=stuService.fetchStudent(id);
		if(student.equals(null)) {
			return null;
		}
		else {
			return student;
		}
	}
	
	@GetMapping("/fetchAllStudent")
	public List<StudentPOJO> fetchAllStudent() {
		List<StudentPOJO> students=stuService.fetchAllStudent();
		if(students.equals(null)) {
			return null;
		}
		else {
			return students;
		}
		
	}
	
	@GetMapping("/fetchAddress")
	public Set<String> fetchAddress() {
		Set<String> addresses=stuService.fetchAddress();
		if(addresses.equals(null)) {
			return null;
		}
		else {
			return addresses;
		}
		
	}
	
	
	@PutMapping("/updateStudent")
	public  StudentPOJO updateStudent(@RequestBody StudentPOJO stu) {
		StudentPOJO student=stuService.updateStudent(stu);
		if(student.equals(null)) {
			return null;
		}else {
			return student;
		}
	
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		return stuService.deleteStudent(id);
	}
}
