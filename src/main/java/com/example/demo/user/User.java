package com.example.demo.user;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;



@Entity
@Table(name = "users")
public class User {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String email;
   
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    
    
    public User() {
    	
    }

    public User(String email, String password,Role role) {
        this.email = email;
        this.password = password;
        this.role =role;
        
    }

    public static User create(CreateUserRequest userRequest) {
        String password = "";
        if (!userRequest.getPassword().isEmpty()) {
            password = PASSWORD_ENCODER.encode(userRequest.getPassword());
        }
        return new User(userRequest.getEmail(), password,Role.ADMIN);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public static boolean getEncryptedPassword(String password,String encodedPassword) {
		if(password !=null) {
			boolean isAMatch =	PASSWORD_ENCODER.matches(password, encodedPassword);
			
			return isAMatch;
		}
		return false;
	}
    
}
