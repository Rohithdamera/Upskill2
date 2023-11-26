package com.springBoot.DemoProject.ModelTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.springBoot.DemoProject.Model.StudentModel;

 
public class TestStudent {
	
	 	@Test
	    public void testStudentDetails() {
	        StudentModel student = new StudentModel();
	        student.setName("Alice");
	        student.setAge(20);
	        student.setSalary(50000);

	        Assertions.assertEquals("Alice", student.getName());
	        Assertions.assertEquals(20, student.getAge());
	        Assertions.assertEquals(50000, student.getSalary());
	    }

}
