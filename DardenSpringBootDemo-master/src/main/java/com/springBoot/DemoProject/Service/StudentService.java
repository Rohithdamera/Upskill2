package com.springBoot.DemoProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.DemoProject.Model.StudentModel;
import com.springBoot.DemoProject.Repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
 
	public StudentModel addStudent(StudentModel student) {
		repo.save(student);
		return student;
	}
 
	public List<StudentModel> getStudent() {
		return repo.findAll();
	}
 
	public void deleteStudent(int id) {
		repo.deleteById(id);
		
	}
 
	public StudentModel updateStudent(StudentModel Student, int id) {
		repo.deleteById(id);
		repo.save(Student);
		return Student;
		
	}

}
