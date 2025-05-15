package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class RegisterReq {

    @Schema(description = "使用者的電子郵件", example = "test@example.com", required = true)
    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    @Email(message = ResMessage.ConstantsMessage.EMAIL_FORMAT_ERROR)
    private String email;

    @Schema(description = "使用者的登入密碼", example = "Password123!", required = true)
    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_PASSWORD_ERROR)
    private String password;

    @Schema(description = "使用者的名稱", example = "老王!")
    private String name ="使用者名稱";

    @Schema(description = "使用者的生日", example = "2000-01-01")
    private LocalDate birthdate = LocalDate.now() ;

    @Schema(description = "使用者的身高", example = "180.5")
    private double height =0.0;

    @Schema(description = "使用者的體重", example = "80.5")
    private double weight =0.0;

    @Schema(description = "使用者的生日", example = "輕度工作型態")
    private String workType = "Static";

    @Schema(description = "使用者的性別", example = "man")
    private String gender = "man";

    @Schema(description = "使用者的頭像", example = "Base64格式")
    private String photo ="";

    @Schema(description = "使用者的note", example = "我的note")
    private String note ="";

    @Schema(description = "使用者的理想身材", example = "husky")
    private String bodyType ="";

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getWorkType() {
        return workType;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoto() {
        return photo;
    }

    public String getNote() {
        return note;
    }

    public String getBodyType() {
        return bodyType;
    }
}
