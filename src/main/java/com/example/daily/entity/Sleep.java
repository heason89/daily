package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

import com.example.daily.constants.ResMessage;

@Entity
@Table(name="sleep")
public class Sleep {
    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="sleep_id")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private int sleepId;
    
    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    @Column(name ="email")
    private String email;
    
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_SLEEP_Time_ERROR)
    @Column(name ="sleep_time")
    private LocalDateTime sleepTime;
    
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_AWAKE_Time_ERROR)
    @Column(name ="awake_time")
    private LocalDateTime awakeTime;

    @Column(name ="insomnia")
    private Boolean insomnia;

    @Column(name ="sleep_latency")
    private Boolean sleepLatency;

    @Column(name ="phone")
    private Boolean phone;

	public Sleep() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sleep(int sleepId, @NotBlank(message = "Param email error!") String email,
			@NotNull(message = "Param sleep_time error!") LocalDateTime sleepTime,
			@NotNull(message = "Param awake_time error!") LocalDateTime awakeTime, Boolean insomnia,
			Boolean sleepLatency, Boolean phone) {
		super();
		this.sleepId = sleepId;
		this.email = email;
		this.sleepTime = sleepTime;
		this.awakeTime = awakeTime;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Boolean getPhone() {
		return phone;
	}

	public void setPhone(Boolean phone) {
		this.phone = phone;
	}

 
}
