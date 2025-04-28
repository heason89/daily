package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.daily.constants.ResMessage;

@Entity
@Table(name="meals")
public class Meals {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="meals_id")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private int mealsId;
    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    @Column(name ="email")
    private String email;
    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_MEALS_NAME_ERROR)
    @Column(name ="meals_name")
    private String mealsName;
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_EAT_TIME_ERROR)
    @Column(name ="eat_time")
    private LocalDateTime eatTime;

    public Meals() {
    }

    public Meals(int mealsId, String email, String mealsName, LocalDateTime eatTime) {
        this.mealsId = mealsId;
        this.email = email;
        this.mealsName = mealsName;
        this.eatTime = eatTime;
    }

    public int getMealsId() {
        return mealsId;
    }

    public void setMealsId(int mealsId) {
        this.mealsId = mealsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMealsName() {
        return mealsName;
    }

    public void setMealsName(String mealsName) {
        this.mealsName = mealsName;
    }

    public LocalDateTime getEatTime() {
        return eatTime;
    }

    public void setEatTime(LocalDateTime eatTime) {
        this.eatTime = eatTime;
    }
}
