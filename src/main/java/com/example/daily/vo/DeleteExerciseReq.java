package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DeleteExerciseReq {

    @NotNull(message= ResMessage.ConstantsMessage.PARAM_EXERCISE_ID_ERROR)
    private int exerciseId;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
    private String token;

    public int getExerciseId() {
        return exerciseId;
    }

    public String getToken() {
        return token;
    }
}
