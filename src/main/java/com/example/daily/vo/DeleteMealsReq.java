package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DeleteMealsReq {

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_MEALS_ID_ERROR)
	private int mealsId;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
	private String email;

	public int getMealsId() {
		return mealsId;
	}

	public String getEmail() {
		return email;
	}



	

}
