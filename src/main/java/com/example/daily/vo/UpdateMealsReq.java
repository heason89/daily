package com.example.daily.vo;

import java.time.LocalDateTime;

public class UpdateMealsReq {
	
	private int mealsId;
	
	private String email;

	private String mealsName;
	
	private LocalDateTime eatTime;

	public int getMealsId() {
		return mealsId;
	}

	public String getEmail() {
		return email;
	}

	public String getMealsName() {
		return mealsName;
	}

	public LocalDateTime getEatTime() {
		return eatTime;
	}



}
