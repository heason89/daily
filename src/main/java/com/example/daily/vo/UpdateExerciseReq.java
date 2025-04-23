package com.example.daily.vo;

import java.time.LocalDate;

public class UpdateExerciseReq extends BasicRes{
	
	private int exerciseId;
	
	
	
	private LocalDate date;
	
	private int duration;
	
	private String exerciseName;

	public UpdateExerciseReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateExerciseReq(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public UpdateExerciseReq(int exerciseId, LocalDate date, int duration, String exerciseName) {
		super();
		this.exerciseId = exerciseId;
		this.date = date;
		this.duration = duration;
		this.exerciseName = exerciseName;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
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
