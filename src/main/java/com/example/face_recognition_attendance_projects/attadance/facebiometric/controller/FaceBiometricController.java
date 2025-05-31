package com.example.face_recognition_attendance_projects.attadance.facebiometric.controller;

import com.yourcompany.attendanceapp.facebiometric.dto.FaceScanRequestDTO;
import com.yourcompany.attendanceapp.facebiometric.dto.FaceScanResponseDTO;
import com.yourcompany.attendanceapp.facebiometric.service.FaceScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/face")
public class FaceBiometricController {

    @Autowired
    private FaceScanService faceScanService;

    @PostMapping("/scan")
    public ResponseEntity<FaceScanResponseDTO> scanFace(
            @RequestParam("employeeId") String employeeId,
            @RequestParam("image") MultipartFile image) {

        FaceScanRequestDTO dto = new FaceScanRequestDTO(employeeId, image);
        FaceScanResponseDTO response = faceScanService.scanAndMatch(dto);
        return ResponseEntity.ok(response);
    }
}
