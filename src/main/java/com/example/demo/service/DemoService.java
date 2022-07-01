package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.example.demo.model.Survey;

@Component
public class DemoService {

	
	public  HashMap<String,HashMap<String, Survey>> userReport = new HashMap<>();
	
	
	
	
	public void addContract(Survey survey,String userName) {
		HashMap<String, Survey> contracts = new HashMap<>();
		
		
	       if(userReport.containsKey(userName)){
	    	   contracts =	userReport.get(userName);
	       }
		
		
		Function<? super String, ? extends Survey> addingANewSurvey = new Function<String, Survey>() {
	
		public Survey apply(String t) {
			 return survey;
		}
		
		
		
		};
		contracts.computeIfAbsent(survey.getTitle(), addingANewSurvey );
		BiFunction<? super String, ? super Survey, ? extends Survey> replacingAnExistingSurvey = new BiFunction<String, Survey, Survey>() {
		
		public Survey apply(String t, Survey u) {	return survey;}
		
		
		};
		
		contracts.computeIfPresent(survey.getTitle(), replacingAnExistingSurvey ); //need to check no in future

		
		userReport.put(userName, contracts);
	}
	
	
	public HashMap<String, Survey> getContract(String userName){
		
		System.out.println(userReport);
		HashMap<String, Survey> response = new HashMap<String, Survey>();
		if(userName.equalsIgnoreCase("global@gmail.com")) {
			System.out.println("Inside prematured if statement");
				Set<String>	keys =userReport.keySet();
				
				for(String key : keys) {
					HashMap<String, Survey> tresponse = 	userReport.get(key);
					
					response.putAll(tresponse);
				}
			
				return response;
		}
		
		return	userReport.get(userName);
		
	}
	
}
