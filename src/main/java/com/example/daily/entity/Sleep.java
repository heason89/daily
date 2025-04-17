package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="sleep")
public class Sleep {
    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="sleep_id")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private int sleepId;

    @Column(name ="email")
    private String email;

    @Column(name ="sleep_time")
    private LocalDate sleepTime;

    @Column(name ="awake_time")
    private LocalDate awakeTime;

    @Column(name ="insomnia")
    private Boolean insomnia;

    @Column(name ="sleep_latency")
    private Boolean sleepLatency;

    public int getSleepId() {
        return sleepId;
    }

    public void setSleepId(int sleepId) {
        this.sleepId = sleepId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(LocalDate sleepTime) {
        this.sleepTime = sleepTime;
    }

    public LocalDate getAwakeTime() {
        return awakeTime;
    }

    public void setAwakeTime(LocalDate awakeTime) {
        this.awakeTime = awakeTime;
    }

    public Boolean getInsomnia() {
        return insomnia;
    }

    public void setInsomnia(Boolean insomnia) {
        this.insomnia = insomnia;
    }

    public Boolean getSleepLatency() {
        return sleepLatency;
    }

    public void setSleepLatency(Boolean sleepLatency) {
        this.sleepLatency = sleepLatency;
    }
}
