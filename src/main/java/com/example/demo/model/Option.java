package com.example.demo.model;

import java.io.Serializable;

public class Option implements Serializable{

	
	private static final long serialVersionUID = 6168295222883620178L;
	private String name;
	
	public Option(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
