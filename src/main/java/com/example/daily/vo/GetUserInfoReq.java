package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

public class GetUserInfoReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
