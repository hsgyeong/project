package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration // IoC
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authorize -> authorize
						.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**").permitAll()
						.anyRequest().authenticated()
				)		
				.formLogin(form -> form
						.loginPage("/auth/loginForm").permitAll()
						.defaultSuccessUrl("/",  true) // 로그인 성공 후 리다이렉트
				)
				 .logout(logout -> logout
		                    .logoutUrl("/logout") // 로그아웃 URL
		                    .logoutSuccessUrl("/") // 로그아웃 성공 후 리다이렉트
		            );
		return http.build(); // SecurityFilterChain 빌드
	}
}
