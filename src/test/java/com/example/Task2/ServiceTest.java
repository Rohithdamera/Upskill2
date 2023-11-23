package com.example.Task2;


	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Task2.entity.Student;
import com.example.Task2.repository.StudentRepository;
import com.example.Task2.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.when;
	 
	import java.util.*;
	 
	@ExtendWith(MockitoExtension.class)
	class ServiceTest {

		@Mock
		StudentRepository sRepo;
		@InjectMocks
		StudentService sservice;
		@Test
		public void testGetDetails() {
			List<Student> list=new ArrayList<>();
			list.add(new Student(1,"Ram",24,10000));
			list.add(new Student(2,"Krishna",24,10000));
			list.add(new Student(3,"Vishnu",24,10000));
			list.add(new Student(4,"Sai",24,10000));
			when(sRepo.findAll()).thenReturn(list);
			List<Student> userExpected=sservice.getAllStudents();
			assertEquals(userExpected, list);
		}
		@Test
		public void testAddStudent() {
			Student s=new Student(1,"ravi",25,360000);
			when(sRepo.save(s)).thenReturn(s);
			Student s1=sservice.saveStudent(s);
			assertEquals(s.getId(), s1.getId());
		}
		@Test
		public void testGetById() {
			Student s=new Student(1,"sai",25,3600000);
			when(sRepo.findById(1)).thenReturn(s);
			Student s1=sservice.getStudentById(s.getId());
			assertEquals(s.getId(), s1.getId());
		}

		@Test
		public void testUpdate() {
			Student s=new Student(1,"Chinna",25,2500000);
			Student s1=new Student(1,"swamy",26,2500000);
			when(sRepo.findById(1)).thenReturn(s);
			when(sRepo.save(s)).thenReturn(s);
			Student s2=sservice.updateStudent(s1.getId(),s1);
			assertEquals(s1.getName(), s2.getName());
		}
		@Test
		public void testDelete() {
			Student s=new Student(1,"raghu",25,2500000);
			int studentIdToDelete = s.getId();
			String result = sservice.deleteStudent(studentIdToDelete);
			assertEquals("Deleted",result);
		}
	 
	}

