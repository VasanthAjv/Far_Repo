package com.example.face_recognition_attendance_projects.Manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.face_recognition_attendance_projects.Manager.Entity.DepartmentHr;
import com.example.face_recognition_attendance_projects.Manager.Entity.ManagerEntity;
import com.example.face_recognition_attendance_projects.Manager.EntityDto.ManagerDto;
import com.example.face_recognition_attendance_projects.Manager.repo.ManagerEntityRepo;

@Service
public class ManagerSerivce {

	ManagerEntityRepo entityRepo;

	public ManagerSerivce(ManagerEntityRepo entityRepo) {
		this.entityRepo = entityRepo;
	}

	public String addHrentity(ManagerDto dto) {
		ManagerEntity entity = new ManagerEntity();
		entity.setName(dto.getName());
		entity.setPassword(dto.getPassword());
		entity.setEmail(dto.getEmail());
		entity.setRole(dto.getRole());
		entity.setDepartmentHr(dto.getDepartmentHr());
		return "Hr details Added Succesfully";
	}

	public Optional<List<ManagerEntity>> getalhr() {

		return entityRepo.findByDepartmentHr();
	}

	public Optional<ManagerEntity> getSpecificHr(DepartmentHr departmentHr) {

		return entityRepo.findByDepartmentHr(departmentHr);
	}

	public String updateHrSerivce(ManagerDto dto) {

		ManagerEntity entity = new ManagerEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDepartmentHr(dto.getDepartmentHr());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setRole(dto.getRole());
		entity.setSalary(dto.getSalary());
		entityRepo.save(entity);
		return "Details Updated Succesfully";
	}

	public String deleteHrSerivce(Integer Id) {

		entityRepo.deleteById(Id);

		return "HR Deleted Succesfully ";
	}
}
