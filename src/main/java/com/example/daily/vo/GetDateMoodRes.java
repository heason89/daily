package com.example.daily.vo;

import com.example.daily.entity.Mood;

public class GetDateMoodRes extends BasicRes{
	
	private Mood mood;

	public GetDateMoodRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetDateMoodRes(int code, String message) {
		super(code, message);
		
	}

	public GetDateMoodRes(int code, String message, Mood mood) {
		super(code, message);
		this.mood = mood;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	

}
