package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.blog.config.auth.PrincipalDetailService;

import jakarta.servlet.DispatcherType;

@Configuration // IoC
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable()) // csrf 토큰 비활성화 (테스트시 걸어놓는 것이 좋음)
				.authorizeHttpRequests(authorize -> authorize
						.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**", "/dummy/**")
						.permitAll()
						.anyRequest().authenticated()
				)		
				.formLogin(form -> form
						.loginPage("/auth/loginForm").permitAll()
						.loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 요청 오는 로그인을 가로채서 대신 로그인 하게 됨
						.defaultSuccessUrl("/")
				)
				 .logout(logout -> logout
		                    .logoutUrl("/logout") // 로그아웃 URL
		                    .logoutSuccessUrl("/") // 로그아웃 성공 후 리다이렉트
		        );
		return http.build(); // SecurityFilterChain 빌드
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
