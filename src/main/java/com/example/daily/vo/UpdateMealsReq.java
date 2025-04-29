package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UpdateMealsReq {

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_MEALS_ID_ERROR)
	private int mealsId;

	@NotBlank(message = ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
	private String email;

	@NotBlank(message = ResMessage.ConstantsMessage.PARAM_MEALS_NAME_ERROR)
	private String mealsName;

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_EAT_TIME_ERROR)
	private LocalDateTime eatTime;

	public UpdateMealsReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateMealsReq(int mealsId, String email, String mealsName, LocalDateTime eatTime) {
		super();
		this.mealsId = mealsId;
		this.email = email;
		this.mealsName = mealsName;
		this.eatTime = eatTime;
	}

	public int getMealsId() {
		return mealsId;
	}

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
