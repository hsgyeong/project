package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

// html 파일이 아니라 data를 리턴해주는 controller = RestController
@RestController
public class DummyControllerTest {

	@Autowired		// 의존성 주입 (DI)
	private UserRepository userRepository;
	
	// save 함수는 id를 전달하지 않으면 insert
	// save 함수는 id를 전달하면 해당 id에 대한 데이터가 있을때 update
	// save 함수는 id를 전달하면 해당 id에 대한 데이터가 없을때 insert
	// email, password
	
	@Transactional
	@PutMapping("/dummy/user/{id}")					// @RequestBody JSON 데이터를 받기 위해 사용하는 어노테이션
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) { // JSON 데이터를 요청 -> Java Object MessageConverter의 Jackson 라이브러리가 변환해서 받아줌
		System.out.println("id : " + id);
		System.out.println("password : " + requestUser.getPassword());
		System.out.println("email : " + requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		// userRepository.save(user);
		
		// 더티 체킹
		return null;
	}
	
	// http://localhost:8000/blog/dummy/user
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
	// org.springframework.data.domain.Page
	// 한 페이지당 2건의 데이터를 리턴받을 예정
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users = pagingUser.getContent();
		return users;
	}
	// {id} 주소로 파라미터를 전달 받을 수 있음
	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		// user/4를 찾을 경우 데이터베이스에서 못 찾아오게 되면 user가 null이 되는데
		// return null이 되기 때문에 프로그램에 문제가 됨
		// 이 경우 Optional로 User 객체를 감싸서 가져와서 null인지 아닌지 판단한 후 return
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
			}
		});
		
		/*
		   test -> null을 리턴함
		   User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
		  
		   @Override public User get() { // TODO Auto-generated method stub return new
		   User(); } });
		*/
		
		/*
		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
			@Override
			public User get() {
				// TODO Auto-generated method stub
				return new User();
			}
		});
		*/
		
		/*
		 람다식
		 User user = userRepository.findById(id).orElseThrow(()->{
		 	return new IllegalArgumentException("해당 사용자는 없습니다.");
		 });
		 */
		
		// 요청 : 웹브라우저
		// user 객체 = 자바 오브젝트
		// 변환 (웹 브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
		// 스프링부트 = MessageConverter 응답시 자동 작동
		// 만약 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서 User오브젝트를 json으로 변환해서 브라우저에 던짐
		return user;
	}
	
	/*
	@PostMapping("/dummy/join")
	// http://localhost:8080/blog/dummy/join (요청)
	// http의 body에 username, password, email 데이터를 가지고 요청
	public String join(String username, String password, String email) {	// key = value (약속된 규칙)
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("email : " + email);
		return "회원가입이 완료되었습니다.";
	} 
	*/

	@PostMapping("/dummy/join")
	public String join(User user) {	// key = value (약속된 규칙)
		System.out.println("id : " + user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("createDate : "+ user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	} 
}
