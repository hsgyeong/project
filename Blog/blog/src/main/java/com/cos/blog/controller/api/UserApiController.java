package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;
	
//	@Autowired
//	private HttpSession session;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { //username, password, email
		user.setRole(RoleType.USER);
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),  1); // 자바 오브젝트를 JSON으로 변환해서 리턴 (Jackson)
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){ // key=value, x-www-form-urlencoded (RequestBody X)
		userService.회원수정(user);
		// 트랜잭션이 종료되기 때문에 DB의 값은 변경됨.
		// 하지만 세션 값은 변경되지 않은 상태이기 때문에 직접 세션 값을 변경해 줄 것임.
		
		// 세션 등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	} 

//	 @PostMapping("/api/user/login")
//	 public ResponseDto<Integer> login(@RequestBody User user){
//	 	System.out.println("UserApiController: login호출");
//	 	User principal = userService.로그인(user); // 접근 주체
		
//	 	if(principal != null) {
//			session.setAttribute("principal", principal);
//	 	}
//	 	return new ResponseDto<Integer>(HttpStatus.OK.value(),  1);
//	 }
		
}
