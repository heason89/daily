package com.example.daily.vo;

import java.time.LocalDateTime;

public class UpdateSleepReq {
	
	private int sleepId;
	
	 private LocalDateTime sleepTime;
	 
	 private LocalDateTime awakeTime;
	 
	 private Boolean insomnia;
	 
	 private Boolean sleepLatency;
	 
	 private Boolean phone;

	public int getSleepId() {
		return sleepId;
	}

	public void setSleepId(int sleepId) {
		this.sleepId = sleepId;
	}

	public LocalDateTime getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(LocalDateTime sleepTime) {
		this.sleepTime = sleepTime;
	}

	public LocalDateTime getAwakeTime() {
		return awakeTime;
	}

	public void setAwakeTime(LocalDateTime awakeTime) {
		this.awakeTime = awakeTime;
	}

	public Boolean getInsomnia() {
		return insomnia;
	}

	public void setInsomnia(Boolean insomnia) {
		this.insomnia = insomnia;
	}

	public Boolean getSleepLatency() {
		return sleepLatency;
	}

	public void setSleepLatency(Boolean sleepLatency) {
		this.sleepLatency = sleepLatency;
	}

	public Boolean getPhone() {
		return phone;
	}

	public void setPhone(Boolean phone) {
		this.phone = phone;
	}

	public UpdateSleepReq(int sleepId, LocalDateTime sleepTime, LocalDateTime awakeTime, Boolean insomnia,
			Boolean sleepLatency, Boolean phone) {
		super();
		this.sleepId = sleepId;
		this.sleepTime = sleepTime;
		this.awakeTime = awakeTime;
		this.insomnia = insomnia;
		this.sleepLatency = sleepLatency;
		this.phone = phone;
	}

	public UpdateSleepReq() {
		super();
		// TODO Auto-generated constructor stub
	}

}
