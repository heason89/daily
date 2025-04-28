package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

import com.example.daily.constants.ResMessage;

@Entity
@Table(name="sports")
public class Sports {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="sports_name")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private String sportsName;
    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_SPORTS_TYPE_ERROR)
    @Column(name ="sports_type")
    private String sportsType;
    @Min(value = 1, message = ResMessage.ConstantsMessage.PARAM_CONSUME_ERROR)
    @Column(name ="consume")
    private int consume;
	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sports(String sportsName, @NotBlank(message = "Param sports_type error!") String sportsType,
			@Min(value = 1, message = "Param consume error!") int consume) {
		super();
		this.sportsName = sportsName;
		this.sportsType = sportsType;
		this.consume = consume;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	public String getSportsType() {
		return sportsType;
	}
	public void setSportsType(String sportsType) {
		this.sportsType = sportsType;
	}
	public int getConsume() {
		return consume;
	}
	public void setConsume(int consume) {
		this.consume = consume;
	}

   
}
