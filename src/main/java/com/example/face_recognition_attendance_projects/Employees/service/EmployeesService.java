package com.example.face_recognition_attendance_projects.Employees.service;

import java.util.List;
import com.example.face_recognition_attendance_projects.Employees.dto.EmployeesRequestDTO;
import com.example.face_recognition_attendance_projects.Employees.entity.Employees;
import com.example.face_recognition_attendance_projects.Users.entity.Users;


public interface EmployeesService {

	    Employees createEmployee(EmployeesRequestDTO dto,Long userId);

	    Employees getEmployeeById(Long empId);

	    List<Employees> getAllEmployees();

	    Employees updateEmployee(Long empId, EmployeesRequestDTO dto);

	    void deleteEmployee(Long empId);
}
