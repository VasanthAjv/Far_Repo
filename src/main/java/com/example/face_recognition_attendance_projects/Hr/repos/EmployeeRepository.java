package com.example.face_recognition_attendance_projects.Hr.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.face_recognition_attendance_projects.Hr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
