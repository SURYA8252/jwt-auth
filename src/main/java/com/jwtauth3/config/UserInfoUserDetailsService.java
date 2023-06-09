package com.jwtauth3.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jwtauth3.entities.UserInfo;
import com.jwtauth3.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService{

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = this.userInfoRepository.findByName(username);
		return userInfo.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found !!" + username));
	}

}
