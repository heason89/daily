package com.example.daily.vo;

public class SportsReq extends BasicRes{
	
	private String sportsName;
	
	private String sports_type;
	
	private int consume;

	public SportsReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SportsReq(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public SportsReq(String sportsName, String sports_type, int consume) {
		super();
		this.sportsName = sportsName;
		this.sports_type = sports_type;
		this.consume = consume;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getSports_type() {
		return sports_type;
	}

	public void setSports_type(String sports_type) {
		this.sports_type = sports_type;
	}

	public int getConsume() {
		return consume;
	}

	public void setConsume(int consume) {
		this.consume = consume;
	}
	
	

}
