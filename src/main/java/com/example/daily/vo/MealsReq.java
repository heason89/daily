package com.example.daily.vo;

import java.time.LocalDateTime;

public class MealsReq {

	private String email;
	
	private String mealsName;
	
	private LocalDateTime eatTime;

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
