package com.springBoot.DemoProject.ServiceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springBoot.DemoProject.Model.StudentModel;
import com.springBoot.DemoProject.Repository.StudentRepo;
import com.springBoot.DemoProject.Service.StudentService;

public class StudentServiceTest {

    @Mock
    private StudentRepo studentRepository; // Assuming you have a StudentRepository

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddStudent() {
        StudentModel student = new StudentModel(/* Provide necessary details */);
        
        // Mocking behavior
        when(studentRepository.save(student)).thenReturn(student);
        
        StudentModel savedStudent = studentService.addStudent(student);

        assertEquals(student, savedStudent);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testGetStudents() {
        // Create sample data for testing
        List<StudentModel> students = Arrays.asList(new StudentModel(/* details */), new StudentModel(/* details */));
        
        // Mocking behavior
        when(studentRepository.findAll()).thenReturn(students);
        
        List<StudentModel> result = studentService.getStudent();

        assertEquals(students.size(), result.size());
        // Add further assertions based on your logic
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteStudent() {
        int studentIdToDelete = 1;
        
        // Mocking behavior
        doNothing().when(studentRepository).deleteById(studentIdToDelete);
        
        studentService.deleteStudent(studentIdToDelete);

        verify(studentRepository, times(1)).deleteById(studentIdToDelete);
    }

    @Test
    public void testUpdateStudent() {
        int studentIdToUpdate = 1;
        StudentModel student = new StudentModel(/* details */);

        // Mocking behavior
        when(studentRepository.save(student)).thenReturn(student);
        
        StudentModel updatedStudent = studentService.updateStudent(student, studentIdToUpdate);

        assertEquals(student, updatedStudent);
        verify(studentRepository, times(1)).save(student);
    }
}

