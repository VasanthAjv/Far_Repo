package com.example.face_recognition_attendance_projects.Users.entity;

import java.time.LocalDateTime;
import com.example.face_recognition_attendance_projects.Employees.entity.Employees;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private Long mobileNo;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private LocalDateTime createdAt;
	
	public enum Role{
		ADMIN,
		HR,
		MANAGER,
		EMPLOYEE,
		CANDIDATE
	}
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference
	private Employees employees;
	
}

