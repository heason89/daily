package com.example.daily.entity;

import com.example.daily.constants.ResMessage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name="mood")
@IdClass(value= MoodId.class)
public class Mood {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
    @Column(name ="date")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private LocalDate date;

    @Id
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_USER_ID_ERROR)
    @Column(name ="user_id")
    private int userId;

    @NotNull(message = ResMessage.ConstantsMessage.PARAM_MOOD_ERROR)
    @Column(name ="mood")
    private int mood;

    @Column(name ="diary")
    private String diary;

    public Mood() {
    }

    public Mood(LocalDate date, int userId, int mood, String diary) {
        this.date = date;
        this.userId = userId;
        this.mood = mood;
        this.diary = diary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public String getDiary() {
        return diary;
    }

    public void setDiary(String diary) {
        this.diary = diary;
    }
}
