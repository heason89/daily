package com.example.daily.vo;

import java.time.LocalDate;

import com.example.daily.constants.ResMessage;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GetDateMoodReq {
	
	@NotBlank(message = ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
	private String token;
	
	@NotNull(message= ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
	private LocalDate date;

	public String getToken() {
		return token;
	}

	public LocalDate getDate() {
		return date;
	}

}
