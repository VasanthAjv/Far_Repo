package com.example.face_recognition_attendance_projects.Manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.face_recognition_attendance_projects.Users.entity.Users.Role;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	/*
	 * - leave details repo - notification autowire - chart apis
	 */
	@GetMapping("/leavepermission")
//	 @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'HR','EMPLOYEE')")
	public ResponseEntity<?> getLeave() {
//leave details repo
		return ResponseEntity.ok("Leave Process Fected");
	}

	@PutMapping("/leaveapprove/{id}")
//	 @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'HR','EMPLOYEE')")
	public ResponseEntity<?> updateLeaveStatus(@RequestParam Integer id, @RequestParam String Status) {
// leave update status repo
		return ResponseEntity.ok("Leave Process Fected");
	}

	@GetMapping("/totalabsent")
//	 @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'HR')")
	public ResponseEntity<?> getNumberAbsents(@RequestParam Role role) {
		// number absent via date vice
		return ResponseEntity.ok("Number of leave ");
	}

	@PostMapping("/hrmeeting")
	public ResponseEntity<?> shcudleMeetingToHr(@RequestParam String agenda) {
		// redirect to meeting access
		return ResponseEntity.ok("meeting Updated");
	}

	@GetMapping("/report")
	public ResponseEntity<?> getreport() {
// redirect to report access 
		return ResponseEntity.ok("get report area ");
	}

	@GetMapping("/notification")
	public ResponseEntity<?> notification() {
		// redirect to notification
		return ResponseEntity.ok("get report area ");
	}

	@GetMapping("/chart")
	public ResponseEntity<?> chart() {
// redirect to chart
		return ResponseEntity.ok("get chart flow  ");
	}
}
