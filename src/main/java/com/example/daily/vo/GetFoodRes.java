package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Food;

public class GetFoodRes extends BasicRes{
	
	private List<Food> foodList;

	public GetFoodRes() {
		super();
	}

	public GetFoodRes(int code, String message) {
		super(code, message);
	}

	public GetFoodRes(int code, String message, List<Food> listFood) {
		super(code, message);
		this.foodList = listFood;
	}

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
		
}
