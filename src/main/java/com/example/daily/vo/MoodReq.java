package com.example.daily.vo;

import java.time.LocalDate;

public class MoodReq{
	
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
	 

}
