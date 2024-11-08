package com.project.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.boardback.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

    
}
