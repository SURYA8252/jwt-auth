package com.jwtauth3.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtauth3.dto.AuthRequest;
import com.jwtauth3.entities.UserInfo;
import com.jwtauth3.service.JwtService;
import com.jwtauth3.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserService userService;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	//User Register
	@PostMapping("/register")
	public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo) {
		String addUser = this.userService.addUser(userInfo);
		return new ResponseEntity<String>(addUser,HttpStatus.CREATED);
	}
	@GetMapping("/data")
	public ResponseEntity<Map<String, String>> getData() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "surya");
		map.put("roll-no", "21");
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
	}
	//Generate JWT
	@PostMapping("/auth")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authenticate.isAuthenticated()) {
		   return jwtService.generateToken(authRequest.getUsername());	
		} else {
			throw new UsernameNotFoundException("user not found !!");
		}
	}
	
}
