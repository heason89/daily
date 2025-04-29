package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Meals;

public class SelectMealsRes extends BasicRes{
	
	private List<Meals> meals;

	public SelectMealsRes() {
		super();
	}

	public SelectMealsRes(int code, String message) {
		super(code, message);
	}

	public SelectMealsRes(int code, String message,List<Meals> meals) {
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
