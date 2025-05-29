package com.example.face_recognition_attendance_projects.Users.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFound(UserNotFoundException ex){
    	
    	Map<String , Object> error=new HashMap<>();
    	
    	error.put("timestamp", LocalDateTime.now());
    	error.put("message", ex.getMessage());
    	error.put("status", HttpStatus.NOT_FOUND.value());
    	
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
}
