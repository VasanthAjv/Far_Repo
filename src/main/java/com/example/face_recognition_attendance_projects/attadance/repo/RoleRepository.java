package com.example.face_recognition_attendance_projects.attadance.repo;

import com.yourcompany.attendanceapp.authentication.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
