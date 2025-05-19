package com.example.daily.vo;

import com.example.daily.constants.ResMessage;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SearchMoodInMonthReq {

	@NotBlank(message = ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
	private String token;

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
	private int month;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	

	
	

}
