package com.example.face_recognition_attendance_projects.Hr.serivce.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;
import com.example.face_recognition_attendance_projects.Hr.entity.SalarySlab;

@Service
public class PdfService {
	public String generateOfferPDF(Candidate candidate, SalarySlab slab, LocalDate joiningDate) {
		// Generate PDF file, return saved path
		// e.g., "C:/offers/offer_123.pdf"
		return "/path/to/generated/pdf";
	}
}
