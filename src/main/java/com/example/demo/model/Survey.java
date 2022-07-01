package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

public class Survey implements Serializable{

	
	private static final long serialVersionUID = 442643777536115751L;
	String title;
	String logoPosition;
	List pages;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogoPosition() {
		return logoPosition;
	}
	public void setLogoPosition(String logoPosition) {
		this.logoPosition = logoPosition;
	}
	public List getPages() {
		return pages;
	}
	public void setPages(List pages) {
		this.pages = pages;
	}
	
	
	
	
	
	
}

