package com.example.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody Login login) {
		LoginResponse loginResponse = loginService.login(login);
		HttpStatus httpStatus =	HttpStatus.BAD_REQUEST;
		if(loginResponse.getStatus().equalsIgnoreCase("success")) {
			httpStatus =	HttpStatus.OK;
		}else {
			httpStatus =	HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<LoginResponse>(loginResponse, httpStatus);
		return responseEntity;
	}
	
	
}
