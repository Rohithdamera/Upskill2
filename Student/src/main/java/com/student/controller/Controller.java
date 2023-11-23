package com.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.ServiceImp;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class Controller {
	private static final Logger log = LoggerFactory.getLogger(ServiceImp.class);

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student){
		return studentService.addstudent(student);
	}
	@GetMapping("/all")
	public List<Student> allstudents(){
		return studentService.allstudent();
	}
	@GetMapping("getbyname/{name}")
	public Student getByid(@PathVariable("name") String name) {
		return studentService.getByStudentname(name);
	}
	@DeleteMapping("/delete/{name}")
	private void delete(@PathVariable("name") String name) {
		log.info("Delete Data");
		studentService.deleteStudent(name);
	}
//	@PutMapping("/student/{name}")
//	private Student update(@RequestBody Student student) {
//		log.info("Update Data");
//		return studentService.updateStudent(student);
//	}
}
