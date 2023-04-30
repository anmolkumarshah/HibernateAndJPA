package com.anmolshah.databasedemo.entiry;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@NamedQuery(name = "find_all_query",query = "select p from Person p")
public class Person {
	@Id
	private int id;
	private String name;
	private String location;
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	
	

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	public Person( String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}
	
	

}
