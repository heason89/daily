package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UpdateSleepReq {

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_SLEEP_ID_ERROR)
	private int sleepId;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
	private String token;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_SLEEP_TIME_ERROR)
	private LocalDateTime sleepTime;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_AWAKE_TIME_ERROR)
	private LocalDateTime awakeTime;
	
	@NotNull(message= ResMessage.ConstantsMessage.PARAM_HOURS_ERROR)
	private double hours;
	 
	private Boolean insomnia = false;
	 
	private Boolean sleepLatency = false;
	 
	private Boolean phone =false;

	public int getSleepId() {
		return sleepId;
	}

	public String getToken() {
		return token;
	}

	public LocalDateTime getSleepTime() {
		return sleepTime;
	}

	public LocalDateTime getAwakeTime() {
		return awakeTime;
	}

	public Boolean getInsomnia() {
		return insomnia;
	}

	public Boolean getSleepLatency() {
		return sleepLatency;
	}

	public Boolean getPhone() {
		return phone;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
}
