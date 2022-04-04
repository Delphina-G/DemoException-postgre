package com.example.demoexception;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.NullValueException;
import com.example.exceptions.ResourceNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	
	
	public boolean addStudent(StudentPOJO student) {

		try {
			studentRepo.save(student);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	public StudentPOJO fetchStudent(Integer id) {
		
		try{
			StudentPOJO student=studentRepo.findById(id).orElse(null);
			 return student;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public List<StudentPOJO> fetchAllStudent() {
		
		try {
			List<StudentPOJO> allStudents=(List<StudentPOJO>) studentRepo.findAll();
			return allStudents;
		}catch(Exception e) {
			return null;
		}
		
	}
	
	
	public Set<String> fetchAddress() {
		try {
			Set<String> addresses=new HashSet<>();
			List<StudentPOJO> allStudents=(List<StudentPOJO>) studentRepo.findAll();
			for(StudentPOJO student:allStudents) {
				addresses.add(student.getAddress());
			}
			return addresses;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	public  StudentPOJO updateStudent(StudentPOJO stu) {
		try {
			StudentPOJO student=studentRepo.findById(stu.getId()).orElse(null);
			student.setName(stu.getName());
			student.setMno(stu.getMno());
			student.setAddress(stu.getAddress());
			return studentRepo.save(student);
			
		}
		catch(Exception e) {
			return null;
		}	
	
	}
	
	
	
	
	
	public String deleteStudent(Integer id) {
		try {
			studentRepo.deleteById(id);
			return "student deleted successfully..";
		}
		catch(Exception e) {
			return "Resource Not Found";
		}
	}
}
