package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Food;

public class GetFoodRes extends BasicRes{
	
	private List<Food> listFood;

	public GetFoodRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetFoodRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public GetFoodRes(int code, String message, List<Food> listFood) {
		super(code, message);
		this.listFood = listFood;
	}

	public List<Food> getListFood() {
		return listFood;
	}

	public void setListFood(List<Food> listFood) {
		this.listFood = listFood;
	}
		
}
