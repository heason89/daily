package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Sleep;

public class GetSleepRes extends BasicRes{
	
	private List<Sleep> sleeplist;

	public GetSleepRes() {
		super();
	}

	public GetSleepRes(int code, String message) {
		super(code, message);
	}

	public GetSleepRes(int code, String message, List<Sleep> sleeplist) {
		super(code, message);
		this.sleeplist = sleeplist;
	}

	public List<Sleep> getSleeplist() {
		return sleeplist;
	}

	public void setSleeplist(List<Sleep> sleeplist) {
		this.sleeplist = sleeplist;
	}

}
