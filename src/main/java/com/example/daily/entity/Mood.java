package com.example.daily.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="mood")
@IdClass(value= MoodId.class)
public class Mood {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="date")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private LocalDate date;

    @Id
    @Column(name ="email")
    private String email;

    @Column(name ="mood")
    private int mood;

    @Column(name ="diary")
    private String diary;

    public Mood() {
    }

    public Mood(LocalDate date, String email, int mood, String diary) {
        this.date = date;
        this.email = email;
        this.mood = mood;
        this.diary = diary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
