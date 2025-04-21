package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import com.example.daily.constants.ResMessage;

@Entity
@Table(name="exercise")
public class Exercise {
    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="exercise_id")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private int exerciseId;
    
    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    @Column(name ="email")
    private String email;
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
    @Column(name ="date")
    private LocalDate date;
    @Min(value = 1, message = ResMessage.ConstantsMessage.PARAM_DURATION_ERROR)
    @Column(name ="duration")
    private int duration;
    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_EXERCISENAME_ERROR)
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
