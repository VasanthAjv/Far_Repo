package com.example.face_recognition_attendance_projects.Employees.entity;

import java.time.LocalDate;

import com.example.face_recognition_attendance_projects.Users.entity.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employees {

	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	 @SequenceGenerator(name = "emp_seq", sequenceName = "emp_sequence", initialValue = 101, allocationSize = 1)
	private Long empId;
	
	private String department;
	
	private String designation;
	
	private LocalDate joinedDate;
	
	private Double salary;
	
	private String isActive;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private Users user;
}
