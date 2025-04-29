package com.example.daily.vo;

import java.time.LocalDateTime;

public class UpdateSleepReq {
	
	private int sleepId;

	private String email;
	
	private LocalDateTime sleepTime;
	 
	private LocalDateTime awakeTime;
	 
	private Boolean insomnia;
	 
	private Boolean sleepLatency;
	 
	private Boolean phone;

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
