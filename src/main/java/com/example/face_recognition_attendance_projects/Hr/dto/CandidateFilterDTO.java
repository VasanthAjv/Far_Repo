package com.example.face_recognition_attendance_projects.Hr.dto;

import java.time.LocalDate;

import com.example.face_recognition_attendance_projects.Hr.enums.InterviewStatus;
import com.example.face_recognition_attendance_projects.Hr.enums.ScreeningStatus;

public class CandidateFilterDTO {
	private String name;
	private String email;
	private String phone;
	private String roleHiringFor;
	private String source;

	private Double minYearsOfExperience;
	private Double maxYearsOfExperience;

	private Double minCurrentCTC;
	private Double maxCurrentCTC;

	private Double minExpectedCTC;
	private Double maxExpectedCTC;

	private Integer minNoticePeriod;
	private Integer maxNoticePeriod;

	private LocalDate startCreatedAt;
	private LocalDate endCreatedAt;

	private ScreeningStatus screeningStatus;
	private InterviewStatus interviewStatus;

	public CandidateFilterDTO() {
	}

	public CandidateFilterDTO(String name, String email, String phone, String roleHiringFor, String source,
			Double minYearsOfExperience, Double maxYearsOfExperience, Double minCurrentCTC, Double maxCurrentCTC,
			Double minExpectedCTC, Double maxExpectedCTC, Integer minNoticePeriod, Integer maxNoticePeriod,
			LocalDate startCreatedAt, LocalDate endCreatedAt, ScreeningStatus screeningStatus,
			InterviewStatus interviewStatus) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.roleHiringFor = roleHiringFor;
		this.source = source;
		this.minYearsOfExperience = minYearsOfExperience;
		this.maxYearsOfExperience = maxYearsOfExperience;
		this.minCurrentCTC = minCurrentCTC;
		this.maxCurrentCTC = maxCurrentCTC;
		this.minExpectedCTC = minExpectedCTC;
		this.maxExpectedCTC = maxExpectedCTC;
		this.minNoticePeriod = minNoticePeriod;
		this.maxNoticePeriod = maxNoticePeriod;
		this.startCreatedAt = startCreatedAt;
		this.endCreatedAt = endCreatedAt;
		this.screeningStatus = screeningStatus;
		this.interviewStatus = interviewStatus;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Double getMinYearsOfExperience() {
		return minYearsOfExperience;
	}

	public void setMinYearsOfExperience(Double minYearsOfExperience) {
		this.minYearsOfExperience = minYearsOfExperience;
	}

	public Double getMaxYearsOfExperience() {
		return maxYearsOfExperience;
	}

	public void setMaxYearsOfExperience(Double maxYearsOfExperience) {
		this.maxYearsOfExperience = maxYearsOfExperience;
	}

	public Double getMinCurrentCTC() {
		return minCurrentCTC;
	}

	public void setMinCurrentCTC(Double minCurrentCTC) {
		this.minCurrentCTC = minCurrentCTC;
	}

	public Double getMaxCurrentCTC() {
		return maxCurrentCTC;
	}

	public void setMaxCurrentCTC(Double maxCurrentCTC) {
		this.maxCurrentCTC = maxCurrentCTC;
	}

	public Double getMinExpectedCTC() {
		return minExpectedCTC;
	}

	public void setMinExpectedCTC(Double minExpectedCTC) {
		this.minExpectedCTC = minExpectedCTC;
	}

	public Double getMaxExpectedCTC() {
		return maxExpectedCTC;
	}

	public void setMaxExpectedCTC(Double maxExpectedCTC) {
		this.maxExpectedCTC = maxExpectedCTC;
	}

	public Integer getMinNoticePeriod() {
		return minNoticePeriod;
	}

	public void setMinNoticePeriod(Integer minNoticePeriod) {
		this.minNoticePeriod = minNoticePeriod;
	}

	public Integer getMaxNoticePeriod() {
		return maxNoticePeriod;
	}

	public void setMaxNoticePeriod(Integer maxNoticePeriod) {
		this.maxNoticePeriod = maxNoticePeriod;
	}

	public LocalDate getStartCreatedAt() {
		return startCreatedAt;
	}

	public void setStartCreatedAt(LocalDate startCreatedAt) {
		this.startCreatedAt = startCreatedAt;
	}

	public LocalDate getEndCreatedAt() {
		return endCreatedAt;
	}

	public void setEndCreatedAt(LocalDate endCreatedAt) {
		this.endCreatedAt = endCreatedAt;
	}

	public ScreeningStatus getScreeningStatus() {
		return screeningStatus;
	}

	public void setScreeningStatus(ScreeningStatus screeningStatus) {
		this.screeningStatus = screeningStatus;
	}

	public InterviewStatus getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(InterviewStatus interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	@Override
	public String toString() {
		return "CandidateFilterDTO [name=" + name + ", email=" + email + ", phone=" + phone + ", roleHiringFor="
				+ roleHiringFor + ", source=" + source + ", minYearsOfExperience=" + minYearsOfExperience
				+ ", maxYearsOfExperience=" + maxYearsOfExperience + ", minCurrentCTC=" + minCurrentCTC
				+ ", maxCurrentCTC=" + maxCurrentCTC + ", minExpectedCTC=" + minExpectedCTC + ", maxExpectedCTC="
				+ maxExpectedCTC + ", minNoticePeriod=" + minNoticePeriod + ", maxNoticePeriod=" + maxNoticePeriod
				+ ", startCreatedAt=" + startCreatedAt + ", endCreatedAt=" + endCreatedAt + ", screeningStatus="
				+ screeningStatus + ", interviewStatus=" + interviewStatus + "]";
	}
}
