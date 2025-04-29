package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

public class DeleteFoodReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_FOOD_NAME_ERROR)
    private String foodName;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_COOKING_METHOD_ERROR)
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
