package com.example.face_recognition_attendance_projects.attadance.facebiometric.serivce;

import com.yourcompany.attendanceapp.facebiometric.dto.FaceScanRequestDTO;
import com.yourcompany.attendanceapp.facebiometric.dto.FaceScanResponseDTO;

public interface FaceScanService {
    FaceScanResponseDTO scanAndMatch(FaceScanRequestDTO requestDTO);
}
