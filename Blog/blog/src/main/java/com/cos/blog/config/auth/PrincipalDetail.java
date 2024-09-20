package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Getter;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션 저장소에 저장한다.
@Getter
public class PrincipalDetail implements UserDetails {
	private User user;  // composition

	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료 여부 리턴
	@Override
	public boolean isAccountNonExpired() {
		return UserDetails.super.isAccountNonExpired();
	}

	// 계정 잠금 여부 리턴
	@Override
	public boolean isAccountNonLocked() {
		return UserDetails.super.isAccountNonLocked();
	}

	// 비밀번호 만료 여부 리턴
	@Override
	public boolean isCredentialsNonExpired() {
		return UserDetails.super.isCredentialsNonExpired();
	}

	// 계정 활성화(사용 가능) 여부 리턴
	@Override
	public boolean isEnabled() {
		return UserDetails.super.isEnabled();
	}

	// 계정이 갖고 있는 권한 목록 리턴 (권한이 여러 개 있을 수도 있음)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();

//		collectors.add(new GrantedAuthority() {		
//			@Override
//			public String getAuthority() {
//				return "ROLE_"+user.getRole(); // ROLE_USER
//			}
// 	});

		collectors.add(()->{return "ROLE_"+user.getRole();});
		
		return collectors;
	}
	
}
