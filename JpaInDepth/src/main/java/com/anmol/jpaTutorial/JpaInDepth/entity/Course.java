package com.anmol.jpaTutorial.JpaInDepth.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = "students")
public class Course {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NonNull
	private String name;
	
	@OneToMany(mappedBy = "course")
	List<Review> reviews;
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE_TABLE",joinColumns = @JoinColumn(name="COURSE_ID")
	,inverseJoinColumns = @JoinColumn(name="STUDENT_ID") )
	List<Student> students;
	
	
}
