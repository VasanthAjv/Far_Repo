package com.example.face_recognition_attendance_projects.Hr.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.face_recognition_attendance_projects.Hr.entity.Interview;
import com.example.face_recognition_attendance_projects.Hr.repos.InterviewRepository;
import com.example.face_recognition_attendance_projects.Hr.serivce.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;

	@Override
	public Interview save(Interview interview) {
		return interviewRepository.save(interview);
	}

	@Override
	public Interview findById(Long id) {
		return interviewRepository.findById(id).orElse(null);
	}

	@Override
	public List<Interview> findAll() {
		return interviewRepository.findAll();
	}
}
