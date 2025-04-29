package com.example.daily.vo;

public class DeleteSleepReq {
	
	 private int sleepId;
	 
	 private String email;

	public DeleteSleepReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteSleepReq(int sleepId, String email) {
		super();
		this.sleepId = sleepId;
		this.email = email;
	}

	public int getSleepId() {
		return sleepId;
	}

	public String getEmail() {
		return email;
	}
	 
	 

}
