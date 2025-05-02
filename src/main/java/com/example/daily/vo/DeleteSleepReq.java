package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DeleteSleepReq {

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_SLEEP_ID_ERROR)
	private int sleepId;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
	private String email;

	public int getSleepId() {
		return sleepId;
	}

	public String getEmail() {
		return email;
	}
}
