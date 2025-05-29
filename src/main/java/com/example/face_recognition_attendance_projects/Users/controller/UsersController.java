package com.example.face_recognition_attendance_projects.Users.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.face_recognition_attendance_projects.Users.dto.UserRequestDTO;
import com.example.face_recognition_attendance_projects.Users.entity.Users;
import com.example.face_recognition_attendance_projects.Users.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	private UserService userService;

	public UsersController(UserService userService) {
	
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody UserRequestDTO userRequestDTO){	
		Users user=userService.createUser(userRequestDTO);	
		return ResponseEntity.ok(user);	
	}

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO requestDTO) {
        Users updatedUser = userService.updateUser(id, requestDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    
}