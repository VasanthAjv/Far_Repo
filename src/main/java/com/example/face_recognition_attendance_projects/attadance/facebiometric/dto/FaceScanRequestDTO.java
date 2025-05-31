package com.example.face_recognition_attendance_projects.attadance.facebiometric.dto;

import org.springframework.web.multipart.MultipartFile;

public class FaceScanRequestDTO {
    private String employeeId;
    private MultipartFile image;

    public FaceScanRequestDTO() {
    }

    public FaceScanRequestDTO(String employeeId, MultipartFile image) {
        this.setEmployeeId(employeeId);
        this.setImage(image);
    }

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

   
}

