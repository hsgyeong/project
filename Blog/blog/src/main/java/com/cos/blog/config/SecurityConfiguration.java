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
public class SecurityConfiguration {

	  @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  		http .authorizeHttpRequests(authz -> authz
		  				.requestMatchers("/auth/**").permitAll() .anyRequest().authenticated() )
		  				.formLogin(form -> form .loginPage("/auth/loginForm") .permitAll() )
		  				.logout(logout -> logout .logoutSuccessUrl("/") )
		  				.httpBasic(Customizer.withDefaults()); 
		  				return http.build(); 
		  	}
	  
	   @Bean public WebSecurityCustomizer webSecurityCustomizer() {
		   return (web) -> web.ignoring().requestMatchers("/auth/**");
	   }
	
}
