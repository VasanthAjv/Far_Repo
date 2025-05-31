package com.example.face_recognition_attendance_projects.Hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.ui.Model;

@Controller
public class HrController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/forgot-password")
	public String forgotPassword() {
		return "forgot-password";
	}

	@PostMapping("/home")
	public String home(@RequestParam("employeeid") Long employeeid, @RequestParam("password") String password) {
	    System.out.println("Login attempt with id: " + employeeid + ", pwd: " + password);
	    if (employeeid.equals(1234L) && password.equals("admin123")) {
	        return "admin-dash-board";
	    } else {
	        return "redirect:/login?error=true";
	    }
	}


	@GetMapping("/dash-board")
	public String dashBoard() {
		return "admin-dash-board";
	}
	
	@GetMapping("/add-employee")
	public String addEmployee() {
		return "add-employee";
	}
	
	@GetMapping("/add-project")
	public String addProject() {
		return "add-project";
	}
	
	@GetMapping("/all-employees")
	public String allEmployees() {
		return "all-employees";
	}
	
	@GetMapping("/create-post")
	public String createPost() {
		return "create-post";
	}
	
	@GetMapping("/attendance-status")
	public String status() {
		return "status";
	}
	
	@GetMapping("/payroll")
	public String payrollIntegration() {
		return "payroll-integration";
	}
	
	@GetMapping("/add-admin")
	public String addAdmin() {
		return "add-admin";
	}
	
	@GetMapping("/my-profile")
	public String myProfile() {
		return "my-profile";
	}
	
	@GetMapping("/settings")
	public String settings() {
		return "settings";
	}
}
