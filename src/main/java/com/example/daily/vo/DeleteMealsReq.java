package com.example.daily.vo;

public class DeleteMealsReq {
	
	private String email;

	private int mealsId;

	public DeleteMealsReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteMealsReq(String email, int mealsId) {
		super();
		this.email = email;
		this.mealsId = mealsId;
	}

	public String getEmail() {
		return email;
	}

	public int getMealsId() {
		return mealsId;
	}

	

}
