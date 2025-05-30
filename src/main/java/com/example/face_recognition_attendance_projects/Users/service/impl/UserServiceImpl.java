package com.example.face_recognition_attendance_projects.Users.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.face_recognition_attendance_projects.FaceRecognitionAttendanceProjectsApplication;
import com.example.face_recognition_attendance_projects.Users.dto.UserRequestDTO;
import com.example.face_recognition_attendance_projects.Users.entity.Users;
import com.example.face_recognition_attendance_projects.Users.entity.Users.Role;
import com.example.face_recognition_attendance_projects.Users.exception.UserNotFoundException;
import com.example.face_recognition_attendance_projects.Users.repository.UserRepository;
import com.example.face_recognition_attendance_projects.Users.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final FaceRecognitionAttendanceProjectsApplication faceRecognitionAttendanceProjectsApplication;

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository,
			FaceRecognitionAttendanceProjectsApplication faceRecognitionAttendanceProjectsApplication) {

		this.userRepository = userRepository;
		this.faceRecognitionAttendanceProjectsApplication = faceRecognitionAttendanceProjectsApplication;
	}

	@Override
	public Users createUser(UserRequestDTO userRequestDTO) {
		if (userRequestDTO.getRole() != Role.ADMIN || userRequestDTO.getRole() != Role.MANAGER
				|| userRequestDTO.getRole() != Role.HR) {
			throw new UserNotFoundException("Invalid role: " + userRequestDTO.getRole());
		}
		Users users = Users.builder().userName(userRequestDTO.getUserName()).password(userRequestDTO.getPassword())
				.email(userRequestDTO.getEmail()).mobileNo(userRequestDTO.getMobileNo()).role(userRequestDTO.getRole())
				.createdAt(LocalDateTime.now()).build();

		return userRepository.save(users);
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	@Override // etha method ku security apo condition kudukanum (/id vandha permit nu)
	public Users getUserById(Long id) {

		Users user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with Id : " + id));
		return user;
	}

	@Override
	public Users updateUser(Long id, UserRequestDTO userRequestDTO) {
		if (userRequestDTO.getRole() != Role.ADMIN || userRequestDTO.getRole() != Role.MANAGER
				|| userRequestDTO.getRole() != Role.HR) {
			throw new UserNotFoundException("Invalid role: " + userRequestDTO.getRole());
		}
		Users user = getUserById(id);

		user.setUserName(userRequestDTO.getUserName());
		user.setPassword(userRequestDTO.getPassword());
		user.setEmail(userRequestDTO.getEmail());
		user.setMobileNo(userRequestDTO.getMobileNo());
		user.setRole(userRequestDTO.getRole());

		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {

		Users user = getUserById(id);

		userRepository.delete(user);

	}

}