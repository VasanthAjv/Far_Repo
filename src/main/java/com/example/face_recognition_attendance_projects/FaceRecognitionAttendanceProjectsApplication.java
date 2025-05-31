package com.example.face_recognition_attendance_projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FaceRecognitionAttendanceProjectsApplication {
	static {
		System.load(System.getProperty("user.dir") + "/src/main/resources/lib/opencv_java451.dll");
	}

	public static void main(String[] args) {
		SpringApplication.run(FaceRecognitionAttendanceProjectsApplication.class, args);
	}

}
