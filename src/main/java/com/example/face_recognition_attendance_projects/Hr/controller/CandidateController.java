package com.example.face_recognition_attendance_projects.Hr.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.face_recognition_attendance_projects.Hr.dto.CandidateFilterDTO;
import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;
import com.example.face_recognition_attendance_projects.Hr.export.ExcelExporter;
import com.example.face_recognition_attendance_projects.Hr.serivce.impl.CandidateServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	@Autowired
	CandidateServiceImpl candidateService;

	@PostMapping("/addcandidate")
	public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
		return ResponseEntity.ok(candidateService.addCandidate(candidate));
	}

	@PutMapping("/updates/{id}")
	public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
		return ResponseEntity.ok(candidateService.updateCandidate(id, candidate));
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<Candidate>> getAllCandidates() {
		return ResponseEntity.ok(candidateService.getAllCandidates());
	}

	@GetMapping("/get/email/{email}")
	public ResponseEntity<List<Candidate>> getCandidateByEmail(@PathVariable String email) {
		return ResponseEntity.ok(candidateService.getCandidateByEmail(email));
	}

	@GetMapping("/get/phone/{phone}")
	public ResponseEntity<List<Candidate>> getCandidateByphone(@PathVariable String phone) {
		return ResponseEntity.ok(candidateService.getCandidateByPhone(phone));
	}

	@PostMapping("/filter")
	public List<Candidate> filterCandidates(@RequestBody CandidateFilterDTO filterDTO) {
		return candidateService.filterCandidates(filterDTO);
	}

	@GetMapping("/download/excel")
	public void downloadAllCandidatesAsExcel(HttpServletResponse response) throws IOException {
		List<Candidate> candidates = candidateService.getAllCandidates();
		ExcelExporter.export(candidates, response);
	}

	@PostMapping("/download/excel")
	public void downloadFilteredCandidates(@RequestBody CandidateFilterDTO filter, HttpServletResponse response)
			throws IOException {
		List<Candidate> candidates = candidateService.filterCandidates(filter);
		ExcelExporter.export(candidates, response);
	}
}
