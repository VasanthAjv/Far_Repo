package com.example.face_recognition_attendance_projects.Hr.serivce.impl;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendOfferEmail(String toEmail, String pdfPath) {
        // Send email logic using JavaMailSender or Mail API
        System.out.println("Sending email to " + toEmail + " with PDF " + pdfPath);
    }
}

