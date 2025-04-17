package com.example.daily.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class MoodId implements Serializable {

    private LocalDate time;

    private String email;

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
