package com.anmollearning.springBootSimpleREST.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anmollearning.springBootSimpleREST.Model.Course;

@RestController
public class CourseController {

	@RequestMapping(path = "/courses", method = RequestMethod.GET)
	public List<Course> retriveCourses(){
		return Arrays.asList(
				new Course(1,"Java Masterclass","Anmol"),
				new Course(2,"Python Masterclass","Anmol"),
				new Course(3,"AWS Masterclass","Anmol")
				);
	}
	
}
