package com.example.daily.entity;

import java.io.Serializable;

public class FoodInfoId implements Serializable {

    private String foodName;

    private String cookingMethod;

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
}
