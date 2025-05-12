package com.example.daily.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class MoodId implements Serializable {

    private LocalDate date;

    private int userId;

    public LocalDate getTime() {
        return date;
    }

    public void setTime(LocalDate time) {
        this.date = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
