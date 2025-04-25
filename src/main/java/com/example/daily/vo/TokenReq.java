package com.example.daily.vo;

public class TokenReq {
	
	private String token;
	
	private String password;

	public TokenReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TokenReq(String token, String password) {
		super();
		this.token = token;
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
