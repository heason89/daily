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

    @Column(name ="exercise_name")
    private String exerciseName;

    @Column(name ="start_time")
    private LocalDate startTime;

    @Column(name ="duration")
    private int duration;

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

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
