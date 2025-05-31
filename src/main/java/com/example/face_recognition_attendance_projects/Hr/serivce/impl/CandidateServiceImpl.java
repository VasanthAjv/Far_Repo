package com.example.face_recognition_attendance_projects.Hr.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.face_recognition_attendance_projects.Hr.dto.CandidateFilterDTO;
import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;
import com.example.face_recognition_attendance_projects.Hr.exception.CandidateNotFoundException;
import com.example.face_recognition_attendance_projects.Hr.repos.CandidateRepository;
import com.example.face_recognition_attendance_projects.Hr.serivce.CandidateService;
import com.example.face_recognition_attendance_projects.Hr.specification.CandidateSpecifications;

@Service
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateRepository candidateRepository;

	@Override
	public Candidate addCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public Candidate updateCandidate(Long id, Candidate updatedCandidate) {
		return candidateRepository.findById(id).map(candidate -> {
			candidate.setName(updatedCandidate.getName());
			candidate.setEmail(updatedCandidate.getEmail());
			candidate.setPhone(updatedCandidate.getPhone());
			candidate.setRoleHiringFor(updatedCandidate.getRoleHiringFor());
			candidate.setYearsOfExperience(updatedCandidate.getYearsOfExperience());
			candidate.setCurrentCTC(updatedCandidate.getCurrentCTC());
			candidate.setExpectedCTC(updatedCandidate.getExpectedCTC());
			candidate.setNoticePeriod(updatedCandidate.getNoticePeriod());
			candidate.setSource(updatedCandidate.getSource());
			candidate.setComment(updatedCandidate.getComment());
			candidate.setScreeningStatus(updatedCandidate.getScreeningStatus());
			candidate.setInterviewUpdate(updatedCandidate.getInterviewUpdate());
			candidate.setInterviewStatus(updatedCandidate.getInterviewStatus());
			candidate.setResumeLink(updatedCandidate.getResumeLink());
			return candidateRepository.save(candidate);
		}).orElseThrow(() -> new RuntimeException("Candidate Not Found"));
	}

	@Override
	public List<Candidate> getCandidateByEmail(String email) {
		List<Candidate> candidates = candidateRepository.findByEmail(email);
		if (candidates.isEmpty()) {
			throw new RuntimeException("No candidates found with email: " + email);
		}
		return candidates;
	}

	@Override
	public List<Candidate> getCandidateByPhone(String phone) {
		List<Candidate> candidates = candidateRepository.findByPhone(phone);
		if (candidates.isEmpty()) {
			throw new RuntimeException("No candidates found with phone number: " + phone);
		}
		return candidates;
	}

	@Override
	public List<Candidate> getAllCandidates() {
		return candidateRepository.findAll();
	}

	@Override
	public List<Candidate> filterCandidates(CandidateFilterDTO filterDTO) {
		Specification<Candidate> spec = CandidateSpecifications.withFilters(filterDTO);
		return candidateRepository.findAll(spec);
	}

	@Override
	public Candidate findById(Long id) {
		return candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));
	}

}
