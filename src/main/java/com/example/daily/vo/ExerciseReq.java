package com.example.daily.vo;

import java.time.LocalDate;

public class ExerciseReq extends BasicRes{
	
	 private String email;
	 
	 private LocalDate date;
	 
	 private int duration;
	 
	 private String exerciseName;

	public ExerciseReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExerciseReq(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public ExerciseReq(String email, LocalDate date, int duration, String exerciseName) {
		super();
		this.email = email;
		this.date = date;
		this.duration = duration;
		this.exerciseName = exerciseName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	 
	 

}
