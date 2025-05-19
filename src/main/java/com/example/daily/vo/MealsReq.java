package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class MealsReq {

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
	private String token;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_MEALS_NAME_ERROR)
	private String mealsName;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_EAT_TIME_ERROR)
	private LocalDate eatTime;
	
	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_MEALS_TYPE_ERROR)
	private String mealsType;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMealsName() {
		return mealsName;
	}

	public void setMealsName(String mealsName) {
		this.mealsName = mealsName;
	}

	public LocalDate getEatTime() {
		return eatTime;
	}

	public void setEatTime(LocalDate eatTime) {
		this.eatTime = eatTime;
	}

	public String getMealsType() {
		return mealsType;
	}

	public void setMealsType(String mealsType) {
		this.mealsType = mealsType;
	}
}
