package com.jwt.jwtdemo.repository;


import com.jwt.jwtdemo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String username);
}
