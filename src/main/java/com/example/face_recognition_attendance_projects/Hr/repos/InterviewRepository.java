package com.example.face_recognition_attendance_projects.Hr.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.face_recognition_attendance_projects.Hr.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
