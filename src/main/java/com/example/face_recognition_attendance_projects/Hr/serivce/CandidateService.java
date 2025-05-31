package com.example.face_recognition_attendance_projects.Hr.serivce;

import java.util.List;

import com.example.face_recognition_attendance_projects.Hr.dto.CandidateFilterDTO;
import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;

public interface CandidateService {
	Candidate addCandidate(Candidate candidate);

	Candidate updateCandidate(Long id, Candidate updatedCandidate);

	List<Candidate> getAllCandidates();

	List<Candidate> getCandidateByEmail(String email);

	List<Candidate> getCandidateByPhone(String phone);

	List<Candidate> filterCandidates(CandidateFilterDTO filterDTO);

	Candidate findById(Long id);
}
