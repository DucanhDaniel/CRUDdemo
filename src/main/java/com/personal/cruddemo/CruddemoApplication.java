package com.personal.cruddemo;

import com.personal.cruddemo.dao.StudentDAO;
import com.personal.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			readStudent(studentDAO);
			queryForStudents(studentDAO);
        };
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students
		System.out.println("Getting a list of students...");
		List<Student> listStudent = studentDAO.findAll();
		System.out.println("Getting list of students successfully!");

		// Print list of students
		for (Student student : listStudent)
			System.out.println(student);
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Create new student object ...");
		Student tempStudent = new Student("Daisy", "Ark", "Daisy33@gmail.com");

		// Add student object to the database
		System.out.println("Saving student object ....");
		studentDAO.save(tempStudent);
		System.out.println("Saving student object successfully!");
		System.out.println("Student id: " + tempStudent.getId());

		// Find the student object using the given id
		System.out.println("Finding student using id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println(myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// Create multiple student objects
		System.out.println("Creating new student objects ....");
		Student tempStudent1 = new Student("John", "Doe", "JohnDoe1010@gmail.com");
		Student tempStudent2 = new Student("Smith", "Hence", "Smith889Hence@uni.com");
		Student tempStudent3 = new Student("Linda", "Oka", "LindaOka@gmail.com");
		Student tempStudent4 = new Student("Base", "David", "David@gmail.com");

		// Save the student objects
		System.out.println("Saving student objects ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
	}

	private void createStudent(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating the new student object ....");
		Student tempStudent = new Student("Alex", "Doe", "DoeAlex@gmail.com");

		// Save the student object
		System.out.println("Saving the student object ....");
		studentDAO.save(tempStudent);

		// Display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}















