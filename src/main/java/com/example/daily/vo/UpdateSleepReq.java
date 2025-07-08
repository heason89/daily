package com.example.daily.vo;

import com.example.daily.constants.ResMessage;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class UpdateSleepReq {

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_SLEEP_ID_ERROR)
	private int sleepId;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
	private String token;

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
    private LocalDate date;
	
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

	public LocalDate getDate() {
		return date;
	}

	public double getHours() {
		return hours;
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

	public UpdateSleepReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateSleepReq(@NotNull(message = "Param sleep_id error!") int sleepId,
			@NotBlank(message = "Param token error!") String token,
			@NotNull(message = "Param date error!") LocalDate date,
			@NotNull(message = "Param hours error!") double hours, Boolean insomnia, Boolean sleepLatency,
			Boolean phone) {
		super();
		this.sleepId = sleepId;
		this.token = token;
		this.date = date;
		this.hours = hours;
		this.insomnia = insomnia;
		this.sleepLatency = sleepLatency;
		this.phone = phone;
	}

	
}
