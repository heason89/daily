package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Exercise;

public class GetExerciseRes extends BasicRes{
	
	private List<Exercise> exerciseList;

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(List<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
	}

	public GetExerciseRes() {
	}

	public GetExerciseRes(int code, String message) {
		super(code, message);
	}

	public GetExerciseRes(int code, String message, List<Exercise> exerciselist) {
		super(code, message);
		this.exerciseList = exerciselist;
	}
}
