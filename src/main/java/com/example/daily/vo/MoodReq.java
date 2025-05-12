package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MoodReq{

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
	private LocalDate date;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
	private String token;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_MOOD_ERROR)
	private int mood;
	 
	private String diary;

	public LocalDate getDate() {
		return date;
	}

	public String getToken() {
		return token;
	}

	public int getMood() {
		return mood;
	}

	public String getDiary() {
		return diary;
	}
}
