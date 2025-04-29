package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotNull;

public class UpdateExerciseReq extends ExerciseReq{

	@NotNull(message= ResMessage.ConstantsMessage.PARAM_EXERCISE_ID_ERROR)
	private int exerciseId;

	public int getExerciseId() {
		return exerciseId;
	}
}
