package com.example.face_recognition_attendance_projects.Employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.face_recognition_attendance_projects.Employees.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

}
