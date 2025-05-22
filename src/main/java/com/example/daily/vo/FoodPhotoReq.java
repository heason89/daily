package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

public class FoodPhotoReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_FOOD_NAME_ERROR)
    private String foodName;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_COOKING_METHOD_ERROR)
    private String cookingMethod;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_FOOD_PHOTO_ERROR)
    private String photo;

    public String getFoodName() {
        return foodName;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }

    public String getPhoto() {
        return photo;
    }
}
