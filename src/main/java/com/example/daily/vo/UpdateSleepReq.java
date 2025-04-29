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

	public UpdateSleepReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateSleepReq(int sleepId, String email, LocalDateTime sleepTime, LocalDateTime awakeTime, Boolean insomnia,
			Boolean sleepLatency, Boolean phone) {
		super();
		this.sleepId = sleepId;
		this.email = email;
		this.sleepTime = sleepTime;
		this.awakeTime = awakeTime;
		this.insomnia = insomnia;
		this.sleepLatency = sleepLatency;
		this.phone = phone;
	}

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
