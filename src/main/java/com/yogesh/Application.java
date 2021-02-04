package com.yogesh;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.yogesh.entity.Student;
import com.yogesh.repo.StudentRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	StudentRepo repo=context.getBean(StudentRepo.class);

     System.out.println("Data JPA APP.....!");
	
	/*
	 * Student s=new Student(); s.setStudentId(202);
	 * s.setStudentName("Yogesh shandilya"); s.setStudentEmail("yogi@jlc");
	 * s.setStudentAge(25); repo.save(s);
	 */
	
	Optional<Student> id = repo.findById(202);
	
	if(id.isPresent()) {
		Student s = id.get();
		System.out.println(s);
	}
	else {
		System.out.println("No Record Found");
	}
	context.close();
	
	}

}
