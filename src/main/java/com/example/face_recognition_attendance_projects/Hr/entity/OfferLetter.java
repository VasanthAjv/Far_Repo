package com.example.face_recognition_attendance_projects.Hr.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OfferLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("offerLetters")
    private Candidate candidate;

    @ManyToOne
    private SalarySlab salarySlab;

    private LocalDate joiningDate;
    private String offerStatus; // SENT, RESENT, DECLINED
    private LocalDateTime sentDate;
    
    private String pdfPath; // (Optional) file system path to saved PDF
    
	public OfferLetter() {}

	public OfferLetter(Long id, Candidate candidate, SalarySlab salarySlab, LocalDate joiningDate, String offerStatus,
			LocalDateTime sentDate, String pdfPath) {
		this.id = id;
		this.candidate = candidate;
		this.salarySlab = salarySlab;
		this.joiningDate = joiningDate;
		this.offerStatus = offerStatus;
		this.sentDate = sentDate;
		this.pdfPath = pdfPath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public SalarySlab getSalarySlab() {
		return salarySlab;
	}

	public void setSalarySlab(SalarySlab salarySlab) {
		this.salarySlab = salarySlab;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public LocalDateTime getSentDate() {
		return sentDate;
	}

	public void setSentDate(LocalDateTime sentDate) {
		this.sentDate = sentDate;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	@Override
	public String toString() {
		return "OfferLetter [id=" + id + ", candidate=" + candidate + ", salarySlab=" + salarySlab + ", joiningDate="
				+ joiningDate + ", offerStatus=" + offerStatus + ", sentDate=" + sentDate + ", pdfPath=" + pdfPath
				+ "]";
	}

    
}
