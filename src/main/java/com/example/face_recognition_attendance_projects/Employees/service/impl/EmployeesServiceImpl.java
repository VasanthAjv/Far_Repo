package com.example.face_recognition_attendance_projects.Employees.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.face_recognition_attendance_projects.Employees.dto.EmployeesRequestDTO;
import com.example.face_recognition_attendance_projects.Employees.entity.Employees;
import com.example.face_recognition_attendance_projects.Employees.exception.EmployeeNotFoundException;
import com.example.face_recognition_attendance_projects.Employees.repository.EmployeesRepository;
import com.example.face_recognition_attendance_projects.Employees.service.EmployeesService;
import com.example.face_recognition_attendance_projects.Users.entity.Users;
import com.example.face_recognition_attendance_projects.Users.repository.UserRepository;


@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;
    
    @Autowired
    private UserRepository usersRepository;

    @Override
    public Employees createEmployee(EmployeesRequestDTO dto, Long userId) {

        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Employees employee = Employees.builder()
                .department(dto.getDepartment())
                .designation(dto.getDesignation())
                .joinedDate(dto.getJoinedDate())
                .salary(dto.getSalary())
                .isActive("Active")
                .user(user)
                .build();

        return employeesRepository.save(employee);
    }

    @Override
    public Employees getEmployeeById(Long empId) {
        return employeesRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + empId));
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees updateEmployee(Long empId, EmployeesRequestDTO dto) {
        Employees employee = getEmployeeById(empId);
        employee.setDepartment(dto.getDepartment());
        employee.setDesignation(dto.getDesignation());
        employee.setSalary(dto.getSalary());
        return employeesRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employees employee = getEmployeeById(empId);
        employeesRepository.delete(employee);
    }
}
