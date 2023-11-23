package com.example.Task2;

import com.example.Task2.entity.Student;
import com.example.Task2.service.StudentService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentTest {
	
	private StudentService studentService;
    @Test
    public void testStudent() {
        Student student = new Student(1, "Mani prasad", 20, 50000.0);

        assertEquals(1, student.getId());
        assertEquals("Mani Prasad", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(50000.0, student.getSalary(), 0.01); 
    }



    @Test
    public void testSetters() {
        Student student = new Student();

        student.setId(2);
        student.setName("mani prasad");
        student.setAge(26);
        student.setSalary(670000.0);

        assertEquals(2, student.getId());
        assertEquals("prasad", student.getName());
        assertEquals(26, student.getAge());
        assertEquals(670000.0, student.getSalary(), 0.01);
    }

    @Test
    public void testToString() {
        Student student = new Student(1, "prasad", 20, 50000.0);

        assertEquals("Student [id=1, name=mani prasad, age=20, salary=45000.0]", student.toString());
    }
    
}
