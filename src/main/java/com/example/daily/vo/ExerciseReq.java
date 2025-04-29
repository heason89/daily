package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ExerciseReq{

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
	private String email;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
	private LocalDate date;

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_DURATION_ERROR)
	private int duration;

	@NotBlank(message= ResMessage.ConstantsMessage.PARAM_EXERCISE_NAME_ERROR)
	private String exerciseName;

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
