package com.example.face_recognition_attendance_projects.Hr.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.face_recognition_attendance_projects.Hr.entity.Employee;
import com.example.face_recognition_attendance_projects.Hr.repos.EmployeeRepository;
import com.example.face_recognition_attendance_projects.Hr.serivce.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
}
