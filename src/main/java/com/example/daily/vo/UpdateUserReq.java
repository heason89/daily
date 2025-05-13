package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class UpdateUserReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_TOKEN_ERROR)
    private String token;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_PASSWORD_ERROR)
    private String password;

    private String name ="使用者名稱";

    private boolean admin = false;
    // 0:帳號註銷 1 :帳號啟用
    private boolean enable = true;

    private LocalDate birthdate =LocalDate.now() ;

    private double height =0;

    private double weight =0;

    private String workType = "Static";

    private String gender = "man";

    private String photo ="";

    private String note ="" ;

    private String bodyType ="";

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isEnable() {
        return enable;
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

    public String getNote() {
        return note;
    }

    public String getPhoto() {
        return photo;
    }

    public String getBodyType() {
        return bodyType;
    }
}
