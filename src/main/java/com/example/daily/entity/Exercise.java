package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="exercise")
public class Exercise {
    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="exercise_id")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private int exerciseId;

    @Column(name ="email")
    private String email;

    @Column(name ="date")
    private LocalDate date;

    @Column(name ="duration")
    private int duration;

    @Column(name ="exercise_name")
    private String exerciseName;

    public Exercise() {
    }

    public Exercise(int exerciseId, String email, LocalDate date,
                    int duration, String exerciseName) {
        this.exerciseId = exerciseId;
        this.email = email;
        this.date = date;
        this.duration = duration;
        this.exerciseName = exerciseName;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
