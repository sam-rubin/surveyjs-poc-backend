package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserErrorHandler {

	@ResponseBody
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ResponseEntity error(Exception exception){
		exception.printStackTrace();
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
