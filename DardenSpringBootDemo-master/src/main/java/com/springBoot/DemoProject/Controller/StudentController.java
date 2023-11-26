package com.springBoot.DemoProject.Controller;

import java.util.List;

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

import com.springBoot.DemoProject.Model.StudentModel;
import com.springBoot.DemoProject.Service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
	

	 
		@Autowired
		private StudentService studentService;
		
		@PostMapping("/add")
		public ResponseEntity<StudentModel> addStudent(@RequestBody StudentModel student) {
			
			studentService.addStudent(student);
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		}
		
		@GetMapping("/get")
		public List<StudentModel> getStudent(){
			return studentService.getStudent();
		}
		
		@DeleteMapping("/deleteStudents/{id}")
		public String deleteStudent(@PathVariable("id") int id) {
			studentService.deleteStudent(id);
			return "Student deleted";
		}
		
		@PutMapping("/updateStudents/{id}")
		public StudentModel updateStudent(@RequestBody StudentModel student, @PathVariable("id") int id) {
			return  studentService.updateStudent(student,id);
		}
		
	}


