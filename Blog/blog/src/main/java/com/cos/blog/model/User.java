package com.cos.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
//ORM -> Java (포함 다른 언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL에 테이블이 생성된다.
// @DynamicInsert	// insert 할 때 null 인 필드 제외
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버린 전략을 따라간다. 
	private int id; // 시퀀스, auto_icrement
	
	@Column(nullable = false, length = 100, unique = true)
	private String username; //아이디
	
	@Column(nullable = false, length = 100) // 123456 -> 해쉬 (비밀번호 암호화)
	private String password;
	
	@Column(length = 50) // 카카오에서 이메일을 받아오지 못하기 때문에 nullable=true
	private String email;
	
	// @ColumnDefault("'user'")  // Enum을 쓰는 것이 좋다. -> 데이터 도메인을 만들 수 있음 // admin, user, manager
	// DB는 RoleType이라는 것이 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role;  // Enum 을 쓰는 것이 좋다.  // ADMIN, USER
	
	private String oauth; // kakao
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;
}
