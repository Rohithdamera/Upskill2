package com.student.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.entity.Student;

@org.springframework.stereotype.Repository
public interface StudentRepository extends MongoRepository<Student, String>{

//	Student findByStudentname(String name);
	Student findByStudentName(String studentName);

}
