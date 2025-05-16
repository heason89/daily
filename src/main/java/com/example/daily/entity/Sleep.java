package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import com.example.daily.constants.ResMessage;

@Entity
@Table(name="sleep")
public class Sleep {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="sleep_id")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private int sleepId;

	@NotNull(message = ResMessage.ConstantsMessage.PARAM_USER_ID_ERROR)
    @Column(name ="user_id")
    private int userId;
    
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_SLEEP_TIME_ERROR)
    @Column(name ="sleep_time")
    private LocalDateTime sleepTime;
    
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_AWAKE_TIME_ERROR)
    @Column(name ="awake_time")
    private LocalDateTime awakeTime;
    
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_HOURS_ERROR)
    @Column(name ="hours")
    private double hours;

    @Column(name ="insomnia")
    private boolean insomnia;

    @Column(name ="sleep_latency")
    private boolean sleepLatency;

    @Column(name ="phone")
    private boolean phone;

	public Sleep() {
	}

	public Sleep(int sleepId, @NotNull(message = "Param user_id error!") int userId,
			@NotNull(message = "Param sleep_time error!") LocalDateTime sleepTime,
			@NotNull(message = "Param awake_time error!") LocalDateTime awakeTime,
			@NotNull(message = "Param hours error!") double hours, boolean insomnia, boolean sleepLatency,
			boolean phone) {
		super();
		this.sleepId = sleepId;
		this.userId = userId;
		this.sleepTime = sleepTime;
		this.awakeTime = awakeTime;
		this.hours = hours;
		this.insomnia = insomnia;
		this.sleepLatency = sleepLatency;
		this.phone = phone;
	}

	public int getSleepId() {
		return sleepId;
	}

	public void setSleepId(int sleepId) {
		this.sleepId = sleepId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(LocalDateTime sleepTime) {
		this.sleepTime = sleepTime;
	}

	public LocalDateTime getAwakeTime() {
		return awakeTime;
	}

	public void setAwakeTime(LocalDateTime awakeTime) {
		this.awakeTime = awakeTime;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public boolean isInsomnia() {
		return insomnia;
	}

	public void setInsomnia(boolean insomnia) {
		this.insomnia = insomnia;
	}

	public boolean isSleepLatency() {
		return sleepLatency;
	}

	public void setSleepLatency(boolean sleepLatency) {
		this.sleepLatency = sleepLatency;
	}

	public boolean isPhone() {
		return phone;
	}

	public void setPhone(boolean phone) {
		this.phone = phone;
	}

	
	
}
