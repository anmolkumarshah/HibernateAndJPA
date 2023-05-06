package com.anmol.jpaTutorial.JpaInDepth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anmol.jpaTutorial.JpaInDepth.entity.Course;
import com.anmol.jpaTutorial.JpaInDepth.repository.CourseRepository;

@SpringBootApplication
public class JpaInDepthApplication implements CommandLineRunner {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaInDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("course with id 10001 -> {}",courseRepository.findById(10001));
		courseRepository.deleteById(10002);
		
		Course newCourse = new Course();
		newCourse.setName("Microservices in 100 steps");
		courseRepository.save(newCourse);
	}

}
