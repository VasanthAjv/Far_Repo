package com.example.face_recognition_attendance_projects.Hr.dto;

import java.time.LocalDate;

public class OfferLetterRequestDTO {
    private Long candidateId;
    private Long slabId;
    private LocalDate joiningDate;
	public Long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}
	public Long getSlabId() {
		return slabId;
	}
	public void setSlabId(Long slabId) {
		this.slabId = slabId;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
    
    
}

