package com.example.face_recognition_attendance_projects.Employees.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.face_recognition_attendance_projects.Employees.dto.EmployeesRequestDTO;
import com.example.face_recognition_attendance_projects.Employees.entity.Employees;
import com.example.face_recognition_attendance_projects.Employees.service.EmployeesService;
import com.example.face_recognition_attendance_projects.Users.entity.Users;


@RestController
@RequestMapping("/employee")
public class EmployeesController {

	private EmployeesService employeesService;
	
	    public EmployeesController(EmployeesService employeesService) {
		super();
		this.employeesService = employeesService;
	}

	    @PostMapping("/{userId}")
	    public Employees addEmployee(@RequestBody EmployeesRequestDTO requestDTO,
	                                 @PathVariable Long userId) {
	        return employeesService.createEmployee(requestDTO, userId);
	    }


	    @GetMapping
	    public List<Employees> getAllEmployees() {
	        return employeesService.getAllEmployees();
	    }

	    @GetMapping("/{id}")
	    public Employees getEmployeeById(@PathVariable Long id) {
	        return employeesService.getEmployeeById(id);
	    }
	    
	    @PutMapping("/{id}")
	    public Employees updateEmployee(@PathVariable Long id,@RequestBody EmployeesRequestDTO requestDTO) {
	    	return employeesService.updateEmployee(id, requestDTO);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
	        employeesService.deleteEmployee(id);
	    }
	    
}
	


