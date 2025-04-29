package com.example.daily.vo;

import java.time.LocalDateTime;

public class UpdateMealsReq {
	
	private int mealsId;
	
	private String mealsName;
	
	private LocalDateTime eatTime;

	public int getMealsId() {
		return mealsId;
	}

	public void setMealsId(int mealsId) {
		this.mealsId = mealsId;
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
