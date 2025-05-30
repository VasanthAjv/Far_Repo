package com.example.face_recognition_attendance_projects.Manager.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.face_recognition_attendance_projects.Manager.Entity.DepartmentHr;
import com.example.face_recognition_attendance_projects.Manager.Entity.ManagerEntity;

public interface ManagerEntityRepo extends JpaRepository<ManagerEntity, Integer> {

	public Optional<List<ManagerEntity>> findByDepartmentHr();

	public Optional<ManagerEntity> findByDepartmentHr(DepartmentHr departmentHr);

}
