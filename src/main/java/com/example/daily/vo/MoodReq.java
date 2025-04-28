package com.example.daily.vo;

import java.time.LocalDate;

public class MoodReq {
	
	private LocalDate date;
	
	private String email;
	
	 private int mood;
	 
	 private String diary;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMood() {
		return mood;
	}

	public void setMood(int mood) {
		this.mood = mood;
	}

	public String getDiary() {
		return diary;
	}

	public void setDiary(String diary) {
		this.diary = diary;
	}

	public MoodReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoodReq(LocalDate date, String email, int mood, String diary) {
		super();
		this.date = date;
		this.email = email;
		this.mood = mood;
		this.diary = diary;
	}

	

}
