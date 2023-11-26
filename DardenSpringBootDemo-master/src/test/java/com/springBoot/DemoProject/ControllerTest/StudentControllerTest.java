package com.springBoot.DemoProject.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springBoot.DemoProject.Controller.StudentController;
import com.springBoot.DemoProject.Model.StudentModel;
import com.springBoot.DemoProject.Service.StudentService;

public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddStudent() {
        StudentModel student = new StudentModel(/* Provide necessary details */);
        
        // Mocking behavior
        when(studentService.addStudent(student)).thenReturn(student);
        
        ResponseEntity<StudentModel> response = studentController.addStudent(student);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(student, response.getBody());
        verify(studentService, times(1)).addStudent(student);
    }

    @Test
    public void testGetStudents() {
        List<StudentModel> students = Arrays.asList(new StudentModel(/* details */), new StudentModel(/* details */));
        
        // Mocking behavior
        when(studentService.getStudent()).thenReturn(students);
        
        List<StudentModel> result = studentController.getStudent();

        assertEquals(students.size(), result.size());
        // Add further assertions based on your logic
        verify(studentService, times(1)).getStudent();
    }

    @Test
    public void testDeleteStudent() {
        int studentIdToDelete = 1;
        
        String response = studentController.deleteStudent(studentIdToDelete);

        assertEquals("Student deleted", response);
        verify(studentService, times(1)).deleteStudent(studentIdToDelete);
    }

    @Test
    public void testUpdateStudent() {
        int studentIdToUpdate = 1;
        StudentModel student = new StudentModel(/* details */);

        // Mocking behavior
        when(studentService.updateStudent(student, studentIdToUpdate)).thenReturn(student);
        
        StudentModel updatedStudent = studentController.updateStudent(student, studentIdToUpdate);

        assertEquals(student, updatedStudent);
        verify(studentService, times(1)).updateStudent(student, studentIdToUpdate);
    }
}


