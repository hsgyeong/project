package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// 사용자가 요청 -> 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	// http://localhost:8080/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("dori").password("1234").email("dori@nate.com").build();
		System.out.println(TAG+"getter : " + m.getUsername());
		m.setUsername("dori");
		System.out.println(TAG+"setter : " + m.getUsername());
		
		return "lombok test 완료";
	}

	// 인터넷 브라우저 요청은 무조건 get 요청밖에 할 수 없다.
	// http://localhost:8080/http/get (select)
	/*
	@GetMapping("/http/get")
	public String getTest(@RequestParam int id, @RequestParam String username) {
		return "get 요청" + id + ", " + username;
	}
	*/
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/post (insert)
	@PostMapping("/http/post") // text/plain, application/json
	public String postTest(Member m) {
		return "post 요청 : "+ m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/put (update)
	@PostMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	
	//http://localhost:8080/http/delete (delete)
	@PostMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
