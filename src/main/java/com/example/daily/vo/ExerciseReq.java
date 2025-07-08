package com.example.daily.vo;

import com.example.daily.constants.ResMessage;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ExerciseReq {

	@NotBlank(message = ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
	private String token;

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
	private LocalDate date;

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_DURATION_ERROR)
	private int duration;

	@NotBlank(message = ResMessage.ConstantsMessage.PARAM_EXERCISE_NAME_ERROR)
	private String exerciseName;

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_FREQUENCY_ERROR)

	private int frequency;

	public String getToken() {
		return token;
	}

	public LocalDate getDate() {
		return date;
	}

	public int getDuration() {
		return duration;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public int getFrequency() {
		return frequency;
	}
}
