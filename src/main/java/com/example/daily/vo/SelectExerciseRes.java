package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Exercise;

public class SelectExerciseRes extends BasicRes{
	
	private List<Exercise> exerciselist;

	public List<Exercise> getExerciselist() {
		return exerciselist;
	}

	public void setExerciselist(List<Exercise> exerciselist) {
		this.exerciselist = exerciselist;
	}

	public SelectExerciseRes(int code, String message,List<Exercise> exerciselist) {
		super(code,message);
		this.exerciselist = exerciselist;
	}

	public SelectExerciseRes() {
		super();
	}

	public SelectExerciseRes(int code, String message) {
		super(code, message);
	}
}
