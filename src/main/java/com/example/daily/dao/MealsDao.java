package com.example.daily.dao;

import com.example.daily.entity.Meals;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsDao extends JpaRepository<Meals, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "insert into meals (email, meals_name, eat_time )"
			 + "values( :email, :mealsName, :eatTime )" , nativeQuery = true)
	public void insertMeals(//			
			@Param("email") String email,//
			@Param("mealsName")String mealsName, //
			@Param("eatTime")LocalDateTime eatTime);//
			
}
