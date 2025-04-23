package com.example.daily.entity;

import jakarta.persistence.*;

@Entity
@Table(name="food")
@IdClass(value= FoodId.class)
public class Food {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="food_name")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private String foodName;

    @Id
    @Column(name ="cooking_method")
    private String cookingMethod;

    @Column(name ="type")
    private String type;

    @Column(name ="calorie")
    private int calorie;

    @Column(name ="total_fat")
    private int totalFat;

    @Column(name ="trans_fat")
    private int transFat;

    @Column(name ="saturated_fat")
    private int saturatedFat;

    @Column(name ="total_carbohydrate")
    private int totalCarbohydrate;

    @Column(name ="sugar")
    private int sugar;

    @Column(name ="dietary_fiber")
    private int dietaryFiber;

    @Column(name ="protein")
    private int protein;

    @Column(name ="sodium")
    private int sodium;

    @Column(name ="cholesterol")
    private int cholesterol;
    
    @Column(name ="photo")
    private String photo;
    public Food() {
    }
	public Food(String foodName, String cookingMethod, String type, int calorie, int totalFat, int transFat,
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
