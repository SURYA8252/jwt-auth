package com.jwtauth3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtauth3.entities.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
    Optional<UserInfo> findByName(String username);
}
