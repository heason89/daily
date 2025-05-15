package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginReq {

    @Schema(description = "使用者的電子郵件", example = "test@example.com", required = true)
    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    @Email(message = ResMessage.ConstantsMessage.EMAIL_FORMAT_ERROR)
    private String email;

    @Schema(description = "使用者的登入密碼", example = "Password123!", required = true)
    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_PASSWORD_ERROR)
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
