package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class RegisterReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    private String email;

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_PASSWORD_ERROR)
    private String password;

    private String name ="使用者名稱";

    private boolean admin = false;

    // 0:帳號註銷 1 :帳號啟用
    private boolean active = false;

    private LocalDate birthdate = LocalDate.now() ;

    private int height =0;

    private int weight =0;

    private String workType = "Static";

    private String gender = "man";

    private String photo ="";

    private String note ="";

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

    public boolean isAdmin() {
        return admin;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
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
