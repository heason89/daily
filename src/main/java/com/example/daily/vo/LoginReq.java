package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    @Email(message = ResMessage.ConstantsMessage.EMAIL_FORMAT_ERROR)
    private String email;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_PASSWORD_ERROR)
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
