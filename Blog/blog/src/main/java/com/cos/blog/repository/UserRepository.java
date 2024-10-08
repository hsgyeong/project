package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;

// JpaRepository 는 User 테이블이 관리하는 repository. user 테이블의 primary key는 integer
// DAO
// 자동으로 bean 등록이 됨
@Repository	// 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
	
	// JPA Naming 쿼리 전략
	// SELECT * FROM user WHERE username = ? AND password = ?;
	// User findByUsernameAndPassword(String username, String password);
	
	// @Query(value="SELECT * FROM user WHERE username = ? AND password = ?;", nativeQuery = true)
	// User login(String username, String password); 
}
