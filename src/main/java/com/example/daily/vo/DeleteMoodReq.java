package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class DeleteMoodReq {

    @NotNull(message= ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
    private LocalDate date;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
    private String token;

    public LocalDate getDate() {
        return date;
    }

    public String getToken() {
        return token;
    }
}
