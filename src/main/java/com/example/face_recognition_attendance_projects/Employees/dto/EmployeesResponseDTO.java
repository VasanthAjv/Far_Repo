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
public class EmployeesResponseDTO {

	    private Long empId;
	    private String department;
	    private String designation;
	    private LocalDate joinedDate;
	    private Double salary;
	    private Boolean isActive;
	    private String userName;
	    private String email;
	    
}
