package com.example.jwtsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtsecuritydemo.model.JwtRequest;
import com.example.jwtsecuritydemo.util.JwtUtil;

@RestController
public class MessageController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String getMesage() {
		return "spring boot with jwt";
	}

	@PostMapping("/generateToken")
	public String generateToken(@RequestBody JwtRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		} catch (Exception ex) {
			throw new Exception("Invalid Credentials.");
		}

		return jwtUtil.generateToken(request.getUserName());
	}
}
