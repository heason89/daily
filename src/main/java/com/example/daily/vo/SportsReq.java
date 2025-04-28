package com.example.daily.vo;

public class SportsReq {
	
	private String sportsName;
	
	private String sportsType;
	
	private int consume;

	public SportsReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SportsReq(String sportsName, String sportsType, int consume) {
		super();
		this.sportsName = sportsName;
		this.sportsType = sportsType;
		this.consume = consume;
	}

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
