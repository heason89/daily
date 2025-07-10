package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Sleep;

public class GetSleepAllRes extends BasicRes {

	private List<Sleep> sleepList;

	public GetSleepAllRes() {

	}

	public GetSleepAllRes(int code, String message) {
		super(code, message);

	}

	public GetSleepAllRes(int code, String message, List<Sleep> sleepList) {
		super(code, message);
		this.sleepList = sleepList;
	}

	public List<Sleep> getSleepList() {
		return sleepList;
	}

}
