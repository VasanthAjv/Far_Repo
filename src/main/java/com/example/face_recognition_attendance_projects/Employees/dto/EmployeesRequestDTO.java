package com.example.face_recognition_attendance_projects.Employees.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeesRequestDTO {

	private String department;
	
	private String designation;
	
	private LocalDate joinedDate;
	
	private Double salary;
	
	private String isActive;
}
