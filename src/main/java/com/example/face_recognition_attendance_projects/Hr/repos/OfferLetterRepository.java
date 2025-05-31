package com.example.face_recognition_attendance_projects.Hr.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.face_recognition_attendance_projects.Hr.entity.OfferLetter;

public interface OfferLetterRepository extends JpaRepository<OfferLetter, Long> {
	List<OfferLetter> findByCandidateId(Long candidateId);
}
