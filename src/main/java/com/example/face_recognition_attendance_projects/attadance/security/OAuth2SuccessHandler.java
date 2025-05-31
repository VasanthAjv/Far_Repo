package com.example.face_recognition_attendance_projects.attadance.security;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.yourcompany.attendanceapp.authentication.Role;
import com.yourcompany.attendanceapp.authentication.User;
import com.yourcompany.attendanceapp.authentication.repository.RoleRepository;
import com.yourcompany.attendanceapp.authentication.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public OAuth2SuccessHandler(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

        String email = oauthUser.getEmail();
        Optional<User> exist = userRepository.findByEmail(email);

        if (exist.isEmpty()) {
            User newUser = new User();
            newUser.setName(oauthUser.getName());
            newUser.setEmail(email);

            // ✅ FIX: store the role into a variable before using it
            Role userRole = roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new RuntimeException("Role ROLE_USER not found"));

            Set<Role> roles = new HashSet<>();
            roles.add(userRole);
            newUser.setRoles(roles);

            newUser.setPassword(""); // optional: for OAuth-only users
            userRepository.save(newUser);
        }

        response.sendRedirect("/dashboard");
    }
}
