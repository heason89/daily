package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class UpdateMealsReq {

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_MEALS_ID_ERROR)
	private int mealsId;

	@NotBlank(message = ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
	private String token;

	@NotBlank(message = ResMessage.ConstantsMessage.PARAM_MEALS_NAME_ERROR)
	private String mealsName;

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_EAT_TIME_ERROR)
	private LocalDate eatTime;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_MEALS_TYPE_ERROR)
	private String mealsType;

	public int getMealsId() {
		return mealsId;
	}

	public String getToken() {
		return token;
	}

	public String getMealsName() {
		return mealsName;
	}

	public LocalDate getEatTime() {
		return eatTime;
	}

	public String getMealsType() {
		return mealsType;
	}

	

}
