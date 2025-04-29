package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UpdateSleepReq {

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_SLEEP_ID_ERROR)
	private int sleepId;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
	private String email;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_SLEEP_TIME_ERROR)
	private LocalDateTime sleepTime;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_AWAKE_TIME_ERROR)
	private LocalDateTime awakeTime;
	 
	private Boolean insomnia = false;
	 
	private Boolean sleepLatency = false;
	 
	private Boolean phone =false;

	public int getSleepId() {
		return sleepId;
	}

	public String getEmail() {
		return email;
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
}
