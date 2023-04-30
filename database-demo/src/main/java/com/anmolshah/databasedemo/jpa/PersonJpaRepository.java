package com.anmolshah.databasedemo.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anmolshah.databasedemo.entiry.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll(){
		TypedQuery<Person> createNamedQuery = entityManager.createNamedQuery("find_all_query", Person.class);
		return createNamedQuery.getResultList();
	}
	
}
