package com.example.face_recognition_attendance_projects.Hr.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long interviewId;

	private LocalDateTime interviewDateTime;

	// Relation to Candidate
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	// Relation to Interviewer (Optional, if you track interviewers)
	@ManyToOne
	@JoinColumn(name = "interviewer_id")
	private Employee interviewer;

	private String interviewLink; // GMeet URL

	public Interview() {
	}

	public Interview(Long interviewId, LocalDateTime interviewDateTime, Candidate candidate, Employee interviewer,
			String interviewLink) {
		this.interviewId = interviewId;
		this.interviewDateTime = interviewDateTime;
		this.candidate = candidate;
		this.interviewer = interviewer;
		this.interviewLink = interviewLink;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public LocalDateTime getInterviewDateTime() {
		return interviewDateTime;
	}

	public void setInterviewDateTime(LocalDateTime interviewDateTime) {
		this.interviewDateTime = interviewDateTime;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Employee getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Employee interviewer) {
		this.interviewer = interviewer;
	}

	public String getInterviewLink() {
		return interviewLink;
	}

	public void setInterviewLink(String interviewLink) {
		this.interviewLink = interviewLink;
	}

	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + ", interviewDateTime=" + interviewDateTime + ", candidate="
				+ candidate + ", interviewer=" + interviewer + ", interviewLink=" + interviewLink + "]";
	}

}
