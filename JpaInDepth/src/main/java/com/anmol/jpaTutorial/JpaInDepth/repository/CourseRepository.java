package com.anmol.jpaTutorial.JpaInDepth.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmol.jpaTutorial.JpaInDepth.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager entityManager;

	public Course findById(int id) {
		return entityManager.find(Course.class, id);
	}

	public void deleteById(int id) {
		Course course = findById(id);
		entityManager.remove(course);
	}

	public void save(Course c) {
		if (c.getId() == null) {
			entityManager.persist(c);
		} else {
			entityManager.merge(c);
		}
	}
	
	public void playingWithEntityManager() {
		Course c1 = new Course("Jr. Science Course");
		Course c2 = new Course("Jr. History Course");
		
		
		entityManager.persist(c1);
		entityManager.persist(c2);

		entityManager.flush();
		
//		entityManager.detach(c2);
		
//		entityManager.clear();
		
		c1.setName("Jr. Science Course - UPDATED");	
		
		entityManager.refresh(c1);
		
		c2.setName("Jr. History Course - UPDATED");
		
		entityManager.flush();
	}
}
