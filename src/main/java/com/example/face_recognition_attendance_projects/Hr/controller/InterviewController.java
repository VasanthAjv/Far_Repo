package com.example.face_recognition_attendance_projects.Hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;
import com.example.face_recognition_attendance_projects.Hr.entity.Employee;
import com.example.face_recognition_attendance_projects.Hr.entity.Interview;
import com.example.face_recognition_attendance_projects.Hr.serivce.CandidateService;
import com.example.face_recognition_attendance_projects.Hr.serivce.EmailService;
import com.example.face_recognition_attendance_projects.Hr.serivce.EmployeeService;
import com.example.face_recognition_attendance_projects.Hr.serivce.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {
	@Autowired
	private EmailService emailService;

	@Autowired
	private CandidateService candidateService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private InterviewService interviewService;

	@PostMapping("/schedule-interview")
	public ResponseEntity<String> scheduleInterview(@RequestBody Interview interview) {
		Candidate candidate = candidateService.findById(interview.getCandidate().getId());
		if (candidate == null) {
			return ResponseEntity.badRequest().body("Invalid Candidate ID");
		}

		Employee interviewer = employeeService.findById(interview.getInterviewer().getEmployeeId());
		if (interviewer == null) {
			return ResponseEntity.badRequest().body("Invalid Interviewer ID");
		}

		interview.setCandidate(candidate);
		interview.setInterviewer(interviewer);

		interviewService.save(interview);

		// Email to Candidate
		String candidateMessage = String.format(
				"Dear %s,\n\nYour interview is scheduled on %s.\nMeeting Link: %s\n\nRegards,\nHR Team",
				candidate.getName(), interview.getInterviewDateTime(), interview.getInterviewLink());
		emailService.sendEmail(candidate.getEmail(), "Interview Scheduled", candidateMessage);

		// Email to Interviewer
		String interviewerMessage = String.format(
				"Dear %s,\n\nYou have an interview with candidate %s on %s.\nMeeting Link: %s\n\nRegards,\nHR Team",
				interviewer.getEmployeeName(), candidate.getName(), interview.getInterviewDateTime(),
				interview.getInterviewLink());
		emailService.sendEmail(interviewer.getEmail(), "Interview Assignment", interviewerMessage);

		return ResponseEntity.ok("Interview scheduled and emails sent.");
	}

}
