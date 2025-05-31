package com.example.face_recognition_attendance_projects.attadance.facebiometric.serivce.impl;

import com.yourcompany.attendanceapp.facebiometric.dto.FaceScanRequestDTO;
import com.yourcompany.attendanceapp.facebiometric.dto.FaceScanResponseDTO;
import com.yourcompany.attendanceapp.facebiometric.entity.FaceScan;
import com.yourcompany.attendanceapp.facebiometric.repository.FaceScanRepository;
import com.yourcompany.attendanceapp.facebiometric.util.FaceRecognitionUtil;
import com.yourcompany.attendanceapp.facebiometric.service.FaceScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FaceScanServiceImpl implements FaceScanService {

    @Autowired
    private FaceScanRepository repository;

    @Autowired
    private FaceRecognitionUtil faceRecognitionUtil;
    
    @Value("${facebiometric.upload-dir}")
    private String uploadDir;

    @Override
    public FaceScanResponseDTO scanAndMatch(FaceScanRequestDTO requestDTO) {
        MultipartFile imageFile = requestDTO.getImage();

        String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
        String path = uploadDir + File.separator + fileName;
        File dest = new File(path);
        
        File folder = new File(uploadDir);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            imageFile.transferTo(dest);
        } catch (IOException e) {
            return new FaceScanResponseDTO(false, "Image upload failed!");
        }

        boolean matched = faceRecognitionUtil.matchFace(path, requestDTO.getEmployeeId());

        FaceScan faceScan = new FaceScan(
                requestDTO.getEmployeeId(),
                path,
                LocalDateTime.now(),
                matched
        );

        repository.save(faceScan);

        return new FaceScanResponseDTO(matched, matched ? "Face matched!" : "Face not recognized.");
    }
}
