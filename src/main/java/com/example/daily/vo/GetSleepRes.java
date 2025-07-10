package com.example.daily.vo;



import com.example.daily.entity.Sleep;

public class GetSleepRes extends BasicRes{
	
	private Sleep sleeplist;

	public GetSleepRes() {
		super();
	}

	public GetSleepRes(int code, String message) {
		super(code, message);
	}

	public GetSleepRes(int code, String message, Sleep sleeplist) {
		super(code, message);
		this.sleeplist = sleeplist;
	}

	public Sleep getSleeplist() {
		return sleeplist;
	}

	public void setSleeplist(Sleep sleeplist) {
		this.sleeplist = sleeplist;
	}

}
