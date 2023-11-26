package com.springBoot.DemoProject.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springBoot.DemoProject.Model.StudentModel;

public interface StudentRepo extends MongoRepository<StudentModel, Integer> {
	 
	

}
