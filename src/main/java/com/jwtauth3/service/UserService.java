package com.jwtauth3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwtauth3.entities.UserInfo;
import com.jwtauth3.repository.UserInfoRepository;

@Service
public class UserService {
	@Autowired
    private UserInfoRepository userInfoRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(this.passwordEncoder.encode(userInfo.getPassword()));
		this.userInfoRepository.save(userInfo);
		return "User added to system...";
	}
}
