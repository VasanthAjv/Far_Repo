package com.example.face_recognition_attendance_projects.attadance.facebiometric.dto;

public class FaceScanResponseDTO {
    private boolean matchFound;
    private String message;
    private String scanTime;
    private String imageUrl;


    public FaceScanResponseDTO() {
    }

    public FaceScanResponseDTO(boolean matchFound, String message) {
        this.setMatchFound(matchFound);
        this.setMessage(message);
    }

	public boolean isMatchFound() {
		return matchFound;
	}

	public void setMatchFound(boolean matchFound) {
		this.matchFound = matchFound;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getScanTime() {
		return scanTime;
	}

	public void setScanTime(String scanTime) {
		this.scanTime = scanTime;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
