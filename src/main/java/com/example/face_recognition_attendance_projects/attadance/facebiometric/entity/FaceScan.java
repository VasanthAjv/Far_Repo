package com.example.face_recognition_attendance_projects.attadance.facebiometric.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "face_scan")
public class FaceScan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;

    private String imagePath;

    private LocalDateTime scanTime;

    private boolean matchFound;

    public FaceScan() {
    }

    public FaceScan(String employeeId, String imagePath, LocalDateTime scanTime, boolean matchFound) {
        this.setEmployeeId(employeeId);
        this.setImagePath(imagePath);
        this.setScanTime(scanTime);
        this.setMatchFound(matchFound);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public LocalDateTime getScanTime() {
		return scanTime;
	}

	public void setScanTime(LocalDateTime scanTime) {
		this.scanTime = scanTime;
	}

	public boolean isMatchFound() {
		return matchFound;
	}

	public void setMatchFound(boolean matchFound) {
		this.matchFound = matchFound;
	}

}
