package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

public class SportsReq{

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_SPORTS_NAME_ERROR)
	private String sportsName;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_SPORTS_TYPE_ERROR)
	private String sportsType;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_CONSUME_ERROR)
	private int consume;

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getSportsType() {
		return sportsType;
	}

	public void setSportsType(String sportsType) {
		this.sportsType = sportsType;
	}

	public int getConsume() {
		return consume;
	}

	public void setConsume(int consume) {
		this.consume = consume;
	}

	

}
