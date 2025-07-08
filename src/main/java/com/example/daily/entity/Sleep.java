package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


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
	
	@NotNull(message = ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
    @Column(name ="date")
    private LocalDate date;
    
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
			@NotNull(message = "Param date error!") LocalDate date,
			@NotNull(message = "Param hours error!") double hours, boolean insomnia, boolean sleepLatency,
			boolean phone) {
		super();
		this.sleepId = sleepId;
		this.userId = userId;
		this.date = date;
		this.hours = hours;
		this.insomnia = insomnia;
		this.sleepLatency = sleepLatency;
		this.phone = phone;
	}

	public int getSleepId() {
		return sleepId;
	}

	public int getUserId() {
		return userId;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getHours() {
		return hours;
	}

	public boolean isInsomnia() {
		return insomnia;
	}

	public boolean isSleepLatency() {
		return sleepLatency;
	}

	public boolean isPhone() {
		return phone;
	}

	
}
