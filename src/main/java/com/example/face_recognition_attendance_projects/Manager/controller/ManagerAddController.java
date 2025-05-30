package com.example.face_recognition_attendance_projects.Manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.face_recognition_attendance_projects.Manager.Entity.ManagerEntity;
import com.example.face_recognition_attendance_projects.Manager.EntityDto.ManagerDto;
import com.example.face_recognition_attendance_projects.Manager.service.ManagerSerivce;

@Controller
public class ManagerAddController {
	ManagerSerivce managerSerivce;

	public ManagerAddController(ManagerSerivce entityRepo) {
		this.managerSerivce = entityRepo;
	}

	@PostMapping()
	public String addHrDetails(ManagerDto dto) {
		String hrentity = managerSerivce.addHrentity(dto);
		return "jsppage";
	}

	@GetMapping("/gethrdetails")
	public String gethrdetails() {
		Optional<List<ManagerEntity>> getalhr = managerSerivce.getalhr();
//model.addAttribute("hrlist",getalahr);
		// model.addAttribute("roles",DepartmentHr);
		return "jsppage";
	}

	@PutMapping("/updatehr")
	public String upadateHr(ManagerDto dto) {
		String updateHrSerivce = managerSerivce.updateHrSerivce(dto);
		return updateHrSerivce;
	}

	@DeleteMapping("/deletehr")
	public String deleteHr(@RequestParam Integer Id) {
		String deleteHrSerivce = managerSerivce.deleteHrSerivce(Id);
		return deleteHrSerivce;

	}

}
