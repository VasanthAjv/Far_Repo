package com.example.face_recognition_attendance_projects.Manager.Entity;

import com.example.face_recognition_attendance_projects.Users.entity.Users.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Role role; // This can be set as HR by the Manager.
	private DepartmentHr departmentHr;// which department hr
	private Long salary;

}
