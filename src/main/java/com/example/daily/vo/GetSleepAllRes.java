package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Sleep;

public class GetSleepAllRes extends BasicRes {

	private List<Sleep> sleeplist;

	public GetSleepAllRes() {

	}

	public GetSleepAllRes(int code, String message) {
		super(code, message);

	}

	public GetSleepAllRes(int code, String message, List<Sleep> sleeplist) {
		super(code, message);
		this.sleeplist = sleeplist;
	}

	public List<Sleep> getSleepList() {
		return sleeplist;
	}

}
