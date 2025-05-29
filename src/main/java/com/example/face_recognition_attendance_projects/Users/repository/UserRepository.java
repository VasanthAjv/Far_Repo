package com.example.face_recognition_attendance_projects.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.face_recognition_attendance_projects.Users.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
