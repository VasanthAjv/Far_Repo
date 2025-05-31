package com.example.face_recognition_attendance_projects.attadance.facebiometric.repo;

import com.yourcompany.attendanceapp.facebiometric.entity.FaceScan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FaceScanRepository extends JpaRepository<FaceScan, Long> {
    List<FaceScan> findByEmployeeId(String employeeId); // Optional: useful for filtering
}
