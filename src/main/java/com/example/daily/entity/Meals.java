package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.daily.constants.ResMessage;

@Entity
@Table(name="meals")
public class Meals {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="meals_id")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private int mealsId;

    @NotNull(message = ResMessage.ConstantsMessage.PARAM_USER_ID_ERROR)
    @Column(name ="user_id")
    private int userId;

    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_MEALS_NAME_ERROR)
    @Column(name ="meals_name")
    private String mealsName;

    @NotNull(message = ResMessage.ConstantsMessage.PARAM_EAT_TIME_ERROR)
    @Column(name ="eat_time")
    private LocalDate eatTime;
    
    @NotNull(message = ResMessage.ConstantsMessage.PARAM_MEALS_TYPE_ERROR)
    @Column(name ="meals_type")
    private String mealsType;

	public Meals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meals(int mealsId, @NotNull(message = "Param user_id error!") int userId,
			@NotBlank(message = "Param meals_name error!") String mealsName,
			@NotNull(message = "Param eat_time error!") LocalDate eatTime,
			@NotNull(message = "Param eat_time error!") String mealsType) {
		super();
		this.mealsId = mealsId;
		this.userId = userId;
		this.mealsName = mealsName;
		this.eatTime = eatTime;
		this.mealsType = mealsType;
	}

	public int getMealsId() {
		return mealsId;
	}

	public void setMealsId(int mealsId) {
		this.mealsId = mealsId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMealsName() {
		return mealsName;
	}

	public void setMealsName(String mealsName) {
		this.mealsName = mealsName;
	}

	public LocalDate getEatTime() {
		return eatTime;
	}

	public void setEatTime(LocalDate eatTime) {
		this.eatTime = eatTime;
	}

	public String getMealsType() {
		return mealsType;
	}

	public void setMealsType(String mealsType) {
		this.mealsType = mealsType;
	}

	
}
