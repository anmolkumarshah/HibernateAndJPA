package com.anmol.jpaTutorial.JpaInDepth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.anmol.jpaTutorial.JpaInDepth.entity.Course;
import com.anmol.jpaTutorial.JpaInDepth.entity.Passport;
import com.anmol.jpaTutorial.JpaInDepth.entity.Review;
import com.anmol.jpaTutorial.JpaInDepth.entity.Student;
import com.anmol.jpaTutorial.JpaInDepth.repository.CourseRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class JpaInDepthApplicationTests {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EntityManager em;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void findById_basic() {
		Course course = courseRepository.findById(10001);
		assertEquals("JPA In Depth", course.getName());
	}

	@Test
	@DirtiesContext
	void deleteById_basic() {
		courseRepository.deleteById(10001);
		assertNull(courseRepository.findById(10001));
	}

	@Test
	@DirtiesContext
	void update_basic() {
		// find course by id
		Course oldCourse = courseRepository.findById(10003);
		assertEquals("Python In Depth", oldCourse.getName());

		// update course
		oldCourse.setName("python 101 updated");

		// save it
		courseRepository.save(oldCourse);

		Course newCourse = courseRepository.findById(10003);
		assertEquals("python 101 updated", newCourse.getName());

	}
	
	@Test
	@DirtiesContext
	public void playWithEntityMangerTest() {
		courseRepository.playingWithEntityManager();
	}
	
	@Test
	@Transactional
	public void fetchPassportFromStudent() {
		Student student = em.find(Student.class, 20001);
		logger.info("student -> {}",student);
		Passport passport = student.getPassport();
		logger.info("passport -> {}",passport);
	}
	
	@Test
	@Transactional
	public void fetchStudentFromPassport() {
		Passport passport = em.find(Passport.class, 30001);
		logger.info("passport -> {}",passport);
		Student student = passport.getStudent();
		logger.info("Student -> {}",student);
	}
	
	@Test
	@Transactional
	public void fetchReviewFromCourse() {
		Course course = em.find(Course.class, 10001);
		logger.info("course -> {}",course);
		List<Review> reviews = course.getReviews();
		logger.info("reviews -> {}",reviews);
	}
	
	@Test
	@Transactional
	public void fetchCourseFromReview() {
		Review review = em.find(Review.class, 40001);
		logger.info("review -> {}",review);
		Course course = review.getCourse();
		logger.info("course -> {}",course);
	}
	

	@Test
	@Transactional
	public void fetchStudentsFromCourse() {
		Course course = em.find(Course.class, 10001);
		logger.info("course -> {}",course);
		List<Student> students = course.getStudents();
		logger.info("students -> {}",students);
	}
}
