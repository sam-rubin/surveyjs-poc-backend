package com.example.demo.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.user.User;
import com.example.demo.user.UserService;

@Component
public class LoginService {

	
	
	@Autowired
	UserService  service;
	
	public LoginResponse login(Login login) {
		LoginResponse response = new  LoginResponse();  
		response.setStatus("failed");
		Optional<User> user =	service.findByEmail(login.getUserName());
		if(user.isPresent()) {
			User  responseUser =	user.get();			
			if(User.getEncryptedPassword(login.getPassword(),responseUser.getPassword())) {
				response.setStatus("success");
			}
		}
		return response;
	}
}
