package com.anmol.jpaTutorial.JpaInDepth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"student"})
public class Passport {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NonNull
	private String number;
	
	@OneToOne(mappedBy = "passport",fetch = FetchType.LAZY)
	private Student student;
}
