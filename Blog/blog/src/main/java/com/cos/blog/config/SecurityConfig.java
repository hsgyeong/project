package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

// bean 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration // bean 등록 (IoC 관리) (스프링 구성 클래스 정의)
@EnableWebSecurity // security 필터 등록
@EnableMethodSecurity(prePostEnabled = true) // Method Security 활성화
public class SecurityConfig {

	@Bean // 스프링 시큐리티 보안 규칙 설정
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((auth) -> auth
						.requestMatchers("/", "/auth/**").permitAll()
						.anyRequest().authenticated() // 나머지 URL은 인증 필요
				)
				.formLogin((form) -> form
						.loginPage("/auth/loginForm").permitAll()
						.defaultSuccessUrl("/", false)
				)
				.logout((logout) -> logout
						.logoutSuccessUrl("/")
				)
				.httpBasic(Customizer.withDefaults())
				.csrf((csrf) -> csrf.disable());
		
		return http.build();
	}
}
