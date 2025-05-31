package com.example.face_recognition_attendance_projects.attadance.playload;

public class JwtAuthResponse {
    private String message;
    private String token;

    public JwtAuthResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

   public String getMessage() {
	   return message;
   }
   public void setMessage(String message) {
	    this.message = message;
	}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
