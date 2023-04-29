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


@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {}",dao.findAll());
		logger.info("\nPerson with it 10002 -> {}",dao.findById(10002));
		logger.info("\nDeleting Person with id 10002, Number of rows deleted -> {}",dao.deleteById(10004));
		logger.info("\ninserting new Person with id 10006 -> {}",dao.insert(new Person(10006, "Harshal", "Gondia", new Date())));
		logger.info("\nupdating person with id 10005 -> {}",dao.update(new Person(10005,"Dhoni","Bihar",new Date())));
	}

}
