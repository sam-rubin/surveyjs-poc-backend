package com.example.demo.user;




public class UserResponse {
    private final String id;
    private final String email;

    public UserResponse(User user) {
        this.id = user.getId().toString();
        this.email = user.getEmail();
    }

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
    
    
}
