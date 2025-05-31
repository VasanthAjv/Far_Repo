package com.example.face_recognition_attendance_projects.Hr.serivce;

import java.util.List;

import com.example.face_recognition_attendance_projects.Hr.entity.Interview;

public interface InterviewService {
	Interview save(Interview interview);

	Interview findById(Long id);

	List<Interview> findAll();

}
