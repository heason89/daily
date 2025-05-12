package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Meals;

public class GetMealsRes extends BasicRes{
	
	private List<Meals> meals;

	public GetMealsRes() {
		super();
	}

	public GetMealsRes(int code, String message) {
		super(code, message);
	}

	public GetMealsRes(int code, String message, List<Meals> meals) {
		super(code, message);
		this.meals = meals;
	}

	public List<Meals> getMeals() {
		return meals;
	}

	public void setMeals(List<Meals> meals) {
		this.meals = meals;
	}
}
