package com.example.face_recognition_attendance_projects.attadance.playload;

public class JwtAuthRequest {
    private String email;
    private String password;

    public JwtAuthRequest() {}

    public JwtAuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

