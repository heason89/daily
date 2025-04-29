package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class MealsReq {

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
	private String email;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_MEALS_NAME_ERROR)
	private String mealsName;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_EAT_TIME_ERROR)
	private LocalDateTime eatTime;

	public String getEmail() {
		return email;
	}

	public String getMealsName() {
		return mealsName;
	}

	public LocalDateTime getEatTime() {
		return eatTime;
	}
}
