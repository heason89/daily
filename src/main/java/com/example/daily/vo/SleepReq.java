package com.example.daily.vo;

import java.time.LocalDateTime;

public class SleepReq extends BasicRes {

	private String email;

	private LocalDateTime sleepTime;

	private LocalDateTime awakeTime;

	private Boolean insomnia;

	private Boolean sleepLatency;

	private Boolean phone;

	public SleepReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SleepReq(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public SleepReq(String email, LocalDateTime sleepTime, LocalDateTime awakeTime, Boolean insomnia,
			Boolean sleepLatency, Boolean phone) {
		super();
		this.email = email;
		this.sleepTime = sleepTime;
		this.awakeTime = awakeTime;
		this.insomnia = insomnia;
		this.sleepLatency = sleepLatency;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
