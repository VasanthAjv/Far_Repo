package com.example.face_recognition_attendance_projects.Manager.EntityDto;

import com.example.face_recognition_attendance_projects.Manager.Entity.DepartmentHr;
import com.example.face_recognition_attendance_projects.Users.entity.Users.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDto {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private Role role; // This can be set as HR by the Manager.
	private DepartmentHr departmentHr;
	private Long salary;
}
