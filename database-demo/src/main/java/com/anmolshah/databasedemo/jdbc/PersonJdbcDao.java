package com.anmolshah.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anmolshah.databasedemo.entiry.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birthdate"));
			return person;
		}
		
	}

	// select * from person
	public List<Person> findAll() {
//		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
//		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] { id },
//				new BeanPropertyRowMapper<Person>(Person.class));
		
		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] { id },
				new PersonRowMapper());
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", new Object[] { id });
	}

	public int insert(Person person) {
		return jdbcTemplate.update("insert into Person(id,name,location,birthdate) values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}

	public int update(Person person) {
		return jdbcTemplate.update("update Person set name = ?,location = ?,birthdate = ? where id = ?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });
	}

}
