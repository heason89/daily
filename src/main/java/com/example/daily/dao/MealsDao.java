package com.example.daily.dao;

import com.example.daily.entity.Meals;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsDao extends JpaRepository<Meals, Integer> {

	@Modifying
	@Transactional
	@Query(value = "insert into meals (user_id, meals_name, eat_time, meals_type )"
			+ "values( :userId, :mealsName, :eatTime, :mealsType)", nativeQuery = true)
	public void insertMeals(//
			@Param("userId") int userId, //
			@Param("mealsName") String mealsName, //
			@Param("eatTime") LocalDate eatTime, //
			@Param("mealsType") String mealsType
			);//

	//全部
	@Query(value = "select * from meals where user_id = ?1 ", nativeQuery = true)
	public List<Meals> GetAllByUserId(int userId);
	//單筆
	@Query(value = "select * from meals where meals_id = ?1 and user_id =?2", nativeQuery = true)
	public Meals GetByMealsId(int mealsId,int userId);
	//當天
	@Query(value = "select * from meals where user_id = ?1 and date(eat_time) = ?2", nativeQuery = true)
	public List<Meals> GetDateMeals(int userId,LocalDate eatDate);
	@Modifying
	@Transactional
	@Query(value = "update meals set meals_name = :mealsName, eat_time = :eatTime, meals_type = :mealsType "
			+ " where  meals_id = :mealsId", nativeQuery = true)
	public void updateMeals(//
			@Param("mealsId") int mealsId, //
			@Param("mealsName") String mealsName, //
			@Param("eatTime") LocalDate eatTime,//
			@Param("mealsType") String mealsType
	);

	@Modifying
	@Transactional
	@Query(value = "delete from meals where meals_id = ?1 ", nativeQuery = true)
	public void deleteMeals(int mealsId);

}
