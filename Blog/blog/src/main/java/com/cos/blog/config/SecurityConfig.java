package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

// bean 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration // bean 등록 (IoC 관리)
@EnableWebSecurity // security 필터 등록
@EnableMethodSecurity(prePostEnabled = true) // Method Security 활성화
public class SecurityConfig {

	  @Bean 
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  		http 
		  				.authorizeHttpRequests((auth) -> auth
		  				.requestMatchers("/", "/auth/**", "/js/**").permitAll() 
		  				.anyRequest().authenticated() 
		  				);
		  		
		  		http
		  				.formLogin((auth) -> auth 
		  							.loginPage("/auth/loginForm")
		  							.defaultSuccessUrl("/") 
		  							.permitAll() 
		  				);
		  		
		  		http
		  				.logout((auth) -> auth
		  						.logoutSuccessUrl("/") 
		  				);
		  		http
		  				.httpBasic(Customizer.withDefaults()); 
		  				
		  		return http.build(); 
		  	}
	  
}
