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

	public FoodReq() {
		super();
	}

	public FoodReq(String foodName, String cookingMethod, String type, int calorie, int totalFat, int transFat,
			int saturatedFat, int totalCarbohydrate, int sugar, int dietaryFiber, int protein, int sodium,
			int cholesterol, String photo) {
		super();
		this.foodName = foodName;
		this.cookingMethod = cookingMethod;
		this.type = type;
		this.calorie = calorie;
		this.totalFat = totalFat;
		this.transFat = transFat;
		this.saturatedFat = saturatedFat;
		this.totalCarbohydrate = totalCarbohydrate;
		this.sugar = sugar;
		this.dietaryFiber = dietaryFiber;
		this.protein = protein;
		this.sodium = sodium;
		this.cholesterol = cholesterol;
		this.photo = photo;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getCookingMethod() {
		return cookingMethod;
	}

	public void setCookingMethod(String cookingMethod) {
		this.cookingMethod = cookingMethod;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public int getTotalFat() {
		return totalFat;
	}

	public void setTotalFat(int totalFat) {
		this.totalFat = totalFat;
	}

	public int getTransFat() {
		return transFat;
	}

	public void setTransFat(int transFat) {
		this.transFat = transFat;
	}

	public int getSaturatedFat() {
		return saturatedFat;
	}

	public void setSaturatedFat(int saturatedFat) {
		this.saturatedFat = saturatedFat;
	}

	public int getTotalCarbohydrate() {
		return totalCarbohydrate;
	}

	public void setTotalCarbohydrate(int totalCarbohydrate) {
		this.totalCarbohydrate = totalCarbohydrate;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public int getDietaryFiber() {
		return dietaryFiber;
	}

	public void setDietaryFiber(int dietaryFiber) {
		this.dietaryFiber = dietaryFiber;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
    
}
