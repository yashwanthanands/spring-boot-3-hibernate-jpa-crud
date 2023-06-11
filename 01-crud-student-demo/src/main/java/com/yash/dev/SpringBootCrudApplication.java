package com.yash.dev;

import com.yash.dev.dao.StudentDAO;
import com.yash.dev.entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO):
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsOrderByLastName(studentDAO);
			   queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("skywalker");

		// display the list of students by lastName
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudentsOrderByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAllOrderByLastName();

		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent= new Student("James","Franklin","james@gmail.com");

		// save the student
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		int theId=tempStudent.getId();
		System.out.println("Saved Student. Generated ID :"+theId);

		// retrieve the student based on the id : primary key
		System.out.println("Retrieve the student by id "+theId);
		Student mystudent= studentDAO.findById(theId);

		// display the student
		System.out.println("Found the student "+mystudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects...");
		Student student1=new Student("Hari","Anand","hari@gmail.com");
		Student student2=new Student("Anakin","Skywalker","anakin@gmail.com");
		Student student3=new Student("Luke","Skywalker","luke@gmail.com");


		//	save the multiple student objects
		System.out.println("Saving the students....");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println("Students Saved.");

	}

	private void createStudent(StudentDAO studentDAO) {
		//creating new student object
		System.out.println("Creating new student object...");
		Student student=new Student("Yashwanth","Anand","yash@gmail.com");

		// save the student object
		System.out.println("Saving the student....");
		studentDAO.save(student);

		// display the id of saved student
		System.out.println("Saved Student. Generated ID :"+student.getId());

	}
}
