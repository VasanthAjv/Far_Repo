package com.example.face_recognition_attendance_projects.Hr.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>, JpaSpecificationExecutor<Candidate> {
	List<Candidate> findByRoleHiringFor(String roleHiringFor);

	List<Candidate> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);

	List<Candidate> findByPhone(String phone);

	List<Candidate> findByEmail(String email);

}
