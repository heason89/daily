package com.example.daily.entity;

import java.io.Serializable;
import java.time.LocalDate;


@SuppressWarnings("serial")
public class MoodId implements Serializable {

    private LocalDate date;

    private String email;

    public LocalDate getTime() {
        return date;
    }

    public void setTime(LocalDate time) {
        this.date = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
