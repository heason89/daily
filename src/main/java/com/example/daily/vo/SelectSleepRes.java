package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Sleep;

public class SelectSleepRes extends BasicRes{
	
	private List<Sleep> sleeplist;

	public SelectSleepRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectSleepRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public SelectSleepRes(int code, String message, List<Sleep> sleeplist) {
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
