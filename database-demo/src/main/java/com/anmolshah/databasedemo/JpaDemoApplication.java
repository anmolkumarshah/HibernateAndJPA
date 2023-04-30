package com.anmolshah.databasedemo;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anmolshah.databasedemo.entiry.Person;
import com.anmolshah.databasedemo.jdbc.PersonJdbcDao;
import com.anmolshah.databasedemo.jpa.PersonJpaRepository;


@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("find by id 10001 -> {}",repository.findById(10001));
		logger.info("\ninserting new Person with id 10006 -> {}",repository.insert(new Person( "Harshal", "Gondia", new Date())));
		logger.info("\nupdating person with id 10005 -> {}",repository.update(new Person(10001,"Dhoni","Bihar",new Date())));
		repository.deleteById(10004);
		logger.info("\nall person -> {}",repository.findAll());
	}

}
