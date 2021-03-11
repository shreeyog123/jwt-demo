package com.jwt.jwtdemo.controller;

import com.jwt.jwtdemo.model.AuthRequest;
import com.jwt.jwtdemo.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class HelloWorldController {

	@Autowired
	private SecurityUtils jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;


	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}


	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
			);
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

}
