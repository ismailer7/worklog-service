package org.worklog.worklogservice.bean;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	
	private final String message;
	
	private  UserDetails userDetails;
	
	public JwtResponse(String jwttoken, String message, UserDetails userDetails) {
		this.jwttoken = jwttoken;
		this.message = message;
		this.userDetails = userDetails;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public UserDetails getUserDetails() {
		return this.userDetails;
	}
}