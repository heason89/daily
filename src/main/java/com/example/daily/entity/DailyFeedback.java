package com.example.daily.entity;

import com.example.daily.constants.ResMessage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name="daily_feedback")
public class DailyFeedback {

    @Id
    @Column(name ="daily_id")
    private int dailyId;

    @NotNull(message = ResMessage.ConstantsMessage.PARAM_USER_ID_ERROR)
    @Column(name ="user_id")
    private int userId;

    @NotNull(message = ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
    @Column(name ="date")
    private LocalDate date;

    @Column(name ="feedback")
    private String feedback;

    public DailyFeedback() {
    }

    public DailyFeedback(int dailyId, int userId, LocalDate date, String feedback) {
        this.dailyId = dailyId;
        this.userId = userId;
        this.date = date;
        this.feedback = feedback;
    }

    public int getDailyId() {
        return dailyId;
    }

    public void setDailyId(int dailyId) {
        this.dailyId = dailyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
