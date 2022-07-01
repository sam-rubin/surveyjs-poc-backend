package com.example.demo.controller;



import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Survey;
import com.example.demo.service.DemoService;

@RestController
public class SurveyController {

	
	@Autowired
	private DemoService demoService;
	
	@PostMapping("/create")
	public void survey(@RequestBody Survey object) {
			
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		demoService.addContract(object,currentPrincipalName);
			
		
	}
	
	
	@GetMapping("/contracts")
	public HashMap<String, Survey> contracts(String user){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println("current principal name "+currentPrincipalName);
		return demoService.getContract(currentPrincipalName); 
		
		
	}
	
}
