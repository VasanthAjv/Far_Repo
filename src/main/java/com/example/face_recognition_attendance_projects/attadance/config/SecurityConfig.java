package com.example.face_recognition_attendance_projects.attadance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;thenticationManager;thenticationManager;thenticationManager;thenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswo
import org.springframework.security.web.SecurityFilterChain;work.security.web.SecurityFilterChain;work.security.web.SecurityFilterChain;work.security.web.SecurityFilterChain;work.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.face_recognition_attendance_projects.attadance.jwt.JwtAuthenticationEntryPoint;
import com.example.face_recognition_attendance_projects.attadance.jwt.JwtAuthenticationFilter;
import com.example.face_recognition_attendance_projects.attadance.security.CustomOAuth2UserService;
import com.example.face_recognition_attendance_projects.attadance.security.OAuth2SuccessHandler;
import com.example.face_recognition_attendance_projects.attadance.serivce.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@SuppressWarnings("unused")
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private CustomOAuth2UserService customOAuth2UserService;

	@Autowired
	private OAuth2SuccessHandler oAuth2SuccessHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).exceptionHandling(ex -> ex.authenticationEntryPoint(unauthorizedHandler))
				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth.requestMatchers("/", "/login", "/register", "/css/**", "/js/**")
						.permitAll().requestMatchers("/api/auth/**").permitAll().requestMatchers("/admin/**")
						.hasRole("ADMIN").requestMatchers("/employee/**").hasRole("EMPLOYEE").anyRequest()
						.authenticated())
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/dashboard", true).permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll())
				.oauth2Login(oauth2 -> oauth2.loginPage("/login")
						.userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
						.successHandler(oAuth2SuccessHandler));

		// Add JWT filter BEFORE UsernamePasswordAuthenticationFilter
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}