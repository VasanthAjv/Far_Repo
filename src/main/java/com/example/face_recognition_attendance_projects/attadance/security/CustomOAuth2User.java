package com.example.face_recognition_attendance_projects.attadance.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomOAuth2User implements OAuth2User {

    private static final Logger logger = LoggerFactory.getLogger(CustomOAuth2User.class);
    private final OAuth2User oauth2User;

    public CustomOAuth2User(OAuth2User oauth2User) {
        this.oauth2User = oauth2User;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        Object name = oauth2User.getAttributes().get("name");
        return name != null ? name.toString() : oauth2User.getName();
    }

    public String getEmail() {
        Object email = oauth2User.getAttributes().get("email");
        if (email == null) {
            logger.warn("⚠️ Email not found in OAuth2 response. Using fallback email.");
            return "unknown@example.com"; // fallback or throw exception
        }
        return email.toString();
    }

    public String getPicture() {
        Object picture = oauth2User.getAttributes().get("picture");
        return picture != null ? picture.toString() : null;
    }
}
