package com.example.daily.entity;

import com.example.daily.constants.ResMessage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name="weekly_feedback")
public class WeeklyFeedback {

    @Id
    @Column(name ="weekly_id")
    private int weeklyId;

    @NotNull(message = ResMessage.ConstantsMessage.PARAM_USER_ID_ERROR)
    @Column(name ="user_id")
    private int userId;

    @NotNull(message = ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
    @Column(name ="date")
    private LocalDate date;

    @Column(name ="feedback")
    private String feedback;

    public WeeklyFeedback() {
    }

    public WeeklyFeedback(int weeklyId, int userId, LocalDate date, String feedback) {
        this.weeklyId = weeklyId;
        this.userId = userId;
        this.date = date;
        this.feedback = feedback;
    }

    public int getWeeklyId() {
        return weeklyId;
    }

    public void setWeeklyId(int weeklyId) {
        this.weeklyId = weeklyId;
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
