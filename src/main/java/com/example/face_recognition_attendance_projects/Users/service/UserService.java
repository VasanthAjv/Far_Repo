package com.example.face_recognition_attendance_projects.Users.service;

import java.util.List;

import com.example.face_recognition_attendance_projects.Users.dto.UserRequestDTO;
import com.example.face_recognition_attendance_projects.Users.entity.Users;

public interface UserService {

	Users createUser(UserRequestDTO userRequestDTO);

	List<Users> getAllUsers();

	Users getUserById(Long id);

	Users updateUser(Long id, UserRequestDTO userRequestDTO);

	void deleteUser(Long id);

}
