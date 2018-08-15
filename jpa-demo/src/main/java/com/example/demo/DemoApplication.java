package com.example.demo;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final Course course = repository.findById(1L);
		log.info("course name: " + course.getName());

		final Course course1 = repository.deleteById(1L);
		log.info("course name: " + course.getName() + ", deleted successfully");

		final Course savedCourse = repository.save(getInstance());
		log.info("saved course name: " + savedCourse.getName());
		repository.functionsOfEntityManager();

		final Course newCourse = getInstance();
		newCourse.setName("Learning JPA and Hibernate");
		repository.save(newCourse);

		final Course updateCourse = repository.findById(1L);
		updateCourse.setName("Learning JPA and Hibernate - UPdated");
		repository.save(updateCourse);

	}

	public static Course getInstance() {
		final Course course = new Course("Learning Artificial Intelligence");
		return course;
	}
}
