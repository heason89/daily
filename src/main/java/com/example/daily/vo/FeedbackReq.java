package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class FeedbackReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
    private String token;

    private LocalDate date;

    private String feedback;

    public String getToken() {
        return token;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFeedback() {
        return feedback;
    }
}
