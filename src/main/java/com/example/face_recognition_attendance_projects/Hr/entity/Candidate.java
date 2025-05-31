package com.example.face_recognition_attendance_projects.Hr.entity;

import java.time.LocalDate;

import com.example.face_recognition_attendance_projects.Hr.enums.InterviewStatus;
import com.example.face_recognition_attendance_projects.Hr.enums.InterviewUpdate;
import com.example.face_recognition_attendance_projects.Hr.enums.ScreeningStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String phone;

	@NotBlank
	private String roleHiringFor;

	@Positive
	private double yearsOfExperience;

	@Positive
	private double currentCTC;

	@Positive
	private double expectedCTC;

	@Min(0)
	private int noticePeriod;

	@NotBlank
	private String source; // e.g., "Naukri"

	@NotBlank
	private String comment;

	@Enumerated(EnumType.STRING)
	private ScreeningStatus screeningStatus = ScreeningStatus.YET_TO_SCREEN;

	@Enumerated(EnumType.STRING)
	private InterviewUpdate interviewUpdate = InterviewUpdate.YET_TO_SCHEDULE;

	@Enumerated(EnumType.STRING)
	private InterviewStatus interviewStatus = InterviewStatus.FEEDBACK_PENDING;

	private String resumeLink; // Optional

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdAt;

	public Candidate() {
	}

	public Candidate(Long id, @NotBlank String name, @Email @NotBlank String email, @NotBlank String phone,
			@NotBlank String roleHiringFor, @Positive double yearsOfExperience, @Positive double currentCTC,
			@Positive double expectedCTC, @Min(0) int noticePeriod, @NotBlank String source, @NotBlank String comment,
			ScreeningStatus screeningStatus, InterviewUpdate interviewUpdate, InterviewStatus interviewStatus,
			String resumeLink, LocalDate createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.roleHiringFor = roleHiringFor;
		this.yearsOfExperience = yearsOfExperience;
		this.currentCTC = currentCTC;
		this.expectedCTC = expectedCTC;
		this.noticePeriod = noticePeriod;
		this.source = source;
		this.comment = comment;
		this.screeningStatus = screeningStatus;
		this.interviewUpdate = interviewUpdate;
		this.interviewStatus = interviewStatus;
		this.resumeLink = resumeLink;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoleHiringFor() {
		return roleHiringFor;
	}

	public void setRoleHiringFor(String roleHiringFor) {
		this.roleHiringFor = roleHiringFor;
	}

	public double getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public double getCurrentCTC() {
		return currentCTC;
	}

	public void setCurrentCTC(double currentCTC) {
		this.currentCTC = currentCTC;
	}

	public double getExpectedCTC() {
		return expectedCTC;
	}

	public void setExpectedCTC(double expectedCTC) {
		this.expectedCTC = expectedCTC;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ScreeningStatus getScreeningStatus() {
		return screeningStatus;
	}

	public void setScreeningStatus(ScreeningStatus screeningStatus) {
		this.screeningStatus = screeningStatus;
	}

	public InterviewUpdate getInterviewUpdate() {
		return interviewUpdate;
	}

	public void setInterviewUpdate(InterviewUpdate interviewUpdate) {
		this.interviewUpdate = interviewUpdate;
	}

	public InterviewStatus getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(InterviewStatus interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getResumeLink() {
		return resumeLink;
	}

	public void setResumeLink(String resumeLink) {
		this.resumeLink = resumeLink;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", roleHiringFor="
				+ roleHiringFor + ", yearsOfExperience=" + yearsOfExperience + ", currentCTC=" + currentCTC
				+ ", expectedCTC=" + expectedCTC + ", noticePeriod=" + noticePeriod + ", source=" + source
				+ ", comment=" + comment + ", screeningStatus=" + screeningStatus + ", interviewUpdate="
				+ interviewUpdate + ", interviewStatus=" + interviewStatus + ", resumeLink=" + resumeLink
				+ ", createdAt=" + createdAt + "]";
	}

}
