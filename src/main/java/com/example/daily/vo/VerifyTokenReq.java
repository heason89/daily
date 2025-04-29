package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

public class VerifyTokenReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
    private String token;

    public String getToken() {
        return token;
    }
}
