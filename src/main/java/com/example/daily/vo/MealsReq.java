package com.example.daily.vo;

import java.time.LocalDateTime;

public class MealsReq extends BasicRes{
	
	private String email;
	
	private String mealsName;
	
	private LocalDateTime eatTime;

	public MealsReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MealsReq(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public MealsReq(String email, String mealsName, LocalDateTime eatTime) {
		super();
		this.email = email;
		this.mealsName = mealsName;
		this.eatTime = eatTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMealsName() {
		return mealsName;
	}

	public void setMealsName(String mealsName) {
		this.mealsName = mealsName;
	}

	public LocalDateTime getEatTime() {
		return eatTime;
	}

	public void setEatTime(LocalDateTime eatTime) {
		this.eatTime = eatTime;
	}
	
	

}
