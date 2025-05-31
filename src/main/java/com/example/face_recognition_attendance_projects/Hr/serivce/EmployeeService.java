package com.example.face_recognition_attendance_projects.Hr.serivce;

import java.util.List;

import com.example.face_recognition_attendance_projects.Hr.entity.Employee;

public interface EmployeeService {
	Employee findById(Long id);

	List<Employee> findAll();

	Employee save(Employee employee);
}
