package com.example.face_recognition_attendance_projects.attadance.controller;

import com.yourcompany.attendanceapp.authentication.Role;
import com.yourcompany.attendanceapp.authentication.User;
import com.yourcompany.attendanceapp.authentication.jwt.JwtTokenProvider;
import com.yourcompany.attendanceapp.authentication.repository.RoleRepository;
import com.yourcompany.attendanceapp.authentication.repository.UserRepository;
import com.yourcompany.attendanceapp.payload.JwtAuthRequest;
import com.yourcompany.attendanceapp.payload.JwtAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // JSP or HTML page for login
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // after login redirect
    }

    // ✅ Login API
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody JwtAuthRequest loginRequest) {
        try {
            @SuppressWarnings("unused")
			Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(), loginRequest.getPassword()
                )
            );

            String token = jwtTokenProvider.generateToken(loginRequest.getEmail());

            JwtAuthResponse response = new JwtAuthResponse("Login successful", token);
            return ResponseEntity.ok(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).body("❌ Invalid email or password!");
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(500).body("❌ Authentication failed!");
        }
    }

    // ✅ Signup API
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("❌ Email already exists!");
        }

        // encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // assign default role
        Role defaultRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("❌ Default role not configured!"));

        user.setRoles(Collections.singleton(defaultRole)); 
        userRepository.save(user);

        return ResponseEntity.ok("✅ User registered successfully!");
    }
    
    @GetMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            String oldToken = bearerToken.substring(7);
            try {
                String newToken = jwtTokenProvider.refreshToken(oldToken);
                return ResponseEntity.ok().body("New Token: " + newToken);
            } catch (Exception e) {
                return ResponseEntity.status(403).body("Invalid or expired token!");
            }
        }
        return ResponseEntity.badRequest().body("Authorization header missing or invalid!");
    }
}
  

//api:Login: POST--> http://localhost:8080/api/auth/login
//api:Login: POST--> http://localhost:8080/api/auth/signup



