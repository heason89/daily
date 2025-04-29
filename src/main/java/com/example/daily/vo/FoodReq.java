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

    private int totalFat =0;

    private int transFat =0;

    private int saturatedFat =0;

    private int totalCarbohydrate =0;

    private int sugar =0;

    private int dietaryFiber =0;

    private int protein =0;

    private int sodium =0;

    private int cholesterol =0;

    private String photo ="";

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

	public int getTotalFat() {
		return totalFat;
	}

	public int getTransFat() {
		return transFat;
	}

	public int getSaturatedFat() {
		return saturatedFat;
	}

	public int getTotalCarbohydrate() {
		return totalCarbohydrate;
	}

	public int getSugar() {
		return sugar;
	}

	public int getDietaryFiber() {
		return dietaryFiber;
	}

	public int getProtein() {
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
}
