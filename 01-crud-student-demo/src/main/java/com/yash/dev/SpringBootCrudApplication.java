package com.yash.dev;

import com.yash.dev.dao.StudentDAO;
import com.yash.dev.entity.Student;
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
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//creating new student object
		Student student=new Student("Yashwanth","Anand","yash@gmail.com");

		// save the student object
		System.out.println("Saving the student....");
		studentDAO.save(student);

		// display the id of saved student
		System.out.println("Saved Student. Generated ID :"+student.getId());

	}
}
