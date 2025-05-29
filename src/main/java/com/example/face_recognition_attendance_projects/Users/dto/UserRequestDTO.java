package com.example.face_recognition_attendance_projects.Users.dto;

import java.time.LocalDateTime;
import com.example.face_recognition_attendance_projects.Users.entity.Users.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private Long mobileNo;

	private Role role;
	
	private LocalDateTime createdAt;

}
