package com.student.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
@Service
public class ServiceImp implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

private static final Logger log = LoggerFactory.getLogger(ServiceImp.class);

	@Override
	public Student addstudent(Student student) {
		studentRepository.save(student);
		log.info("student added");	
		return student;
	}

	@Override
	public List<Student> allstudent() {
		List<Student> allstudents = studentRepository.findAll();
		return allstudents;
	}

	@Override
	public Student getByStudentname(String name) {
		Student getStudent = null; 
		getStudent =studentRepository.findByStudentName(name);
		
		return getStudent;
	}

	@Override
	public void deleteStudent(String name) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(name);
	}
//	@Override
//	public Student updateStudent(Student student) {
//			Student s = new Student();
//			s.setStudentName(student.getStudentName());
//			s.setAge(student.getAge());
//			s.setSalary(student.getSalary());
//			studentRepository.save(student);
//			return s;
//		}
}
//  
