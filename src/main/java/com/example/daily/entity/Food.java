package com.example.daily.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
@IdClass(value = FoodId.class)
public class Food {

	@Id // @Id: 標示此欄位是 PK(primary key)
	@Column(name = "food_name") // @Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
	private String foodName;

	@Id
	@Column(name = "cooking_method")
	private String cookingMethod;

	@Column(name = "type")
	private String type;

	@Column(name = "calorie")
	private int calorie;

	@Column(name = "total_fat")
	private double totalFat;

	@Column(name = "trans_fat")
	private double transFat;

	@Column(name = "saturated_fat")
	private double saturatedFat;

	@Column(name = "total_carbohydrate")
	private double totalCarbohydrate;

	@Column(name = "sugar")
	private double sugar;

	@Column(name = "dietary_fiber")
	private double dietaryFiber;

	@Column(name = "protein")
	private double protein;

	@Column(name = "sodium")
	private int sodium;

	@Column(name = "cholesterol")
	private int cholesterol;

	@Column(name = "photo")
	private String photo;
	
	@Column(name = "unit")
	private String unit;

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String foodName, String cookingMethod, String type, int calorie, double totalFat, double transFat,
			double saturatedFat, double totalCarbohydrate, double sugar, double dietaryFiber, double protein,
			int sodium, int cholesterol, String photo, String unit) {
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
		this.unit = unit;
	}

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
