package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

public class ResetPasswordReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
    private String token;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_PASSWORD_ERROR)
    private String password;

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }
}
