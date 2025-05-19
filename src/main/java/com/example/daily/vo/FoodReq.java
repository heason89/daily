package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

public class FoodReq {

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_FOOD_NAME_ERROR)
    private String foodName;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_COOKING_METHOD_ERROR)
    private String cookingMethod;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_TYPE_ERROR)
    private String type;

    private int calorie =0;

    private double totalFat =0;

    private double transFat =0;

    private double saturatedFat =0;

    private double totalCarbohydrate =0;

    private double sugar =0;

    private double dietaryFiber =0;

    private double protein =0;

    private int sodium =0;

    private int cholesterol =0;

    private String photo ="";
    
    private String unit ="1份";

	public String getFoodName() {
		return foodName;
	}

	public String getCookingMethod() {
		return cookingMethod;
	}

	public String getType() {
		return type;
	}

	public int getCalorie() {
		return calorie;
	}

	public double getTotalFat() {
		return totalFat;
	}

	public double getTransFat() {
		return transFat;
	}

	public double getSaturatedFat() {
		return saturatedFat;
	}

	public double getTotalCarbohydrate() {
		return totalCarbohydrate;
	}

	public double getSugar() {
		return sugar;
	}

	public double getDietaryFiber() {
		return dietaryFiber;
	}

	public double getProtein() {
		return protein;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public String getPhoto() {
		return photo;
	}

	public String getUnit() {
		return unit;
	}
}
