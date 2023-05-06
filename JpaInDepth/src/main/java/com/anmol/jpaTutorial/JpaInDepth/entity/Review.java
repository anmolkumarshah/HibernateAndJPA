package com.anmol.jpaTutorial.JpaInDepth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
public class Review {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NonNull
	private Integer rating;
	
	@NonNull
	private String description;
	
	@ManyToOne
	Course course;
	
	
}
