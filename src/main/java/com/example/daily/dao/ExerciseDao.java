package com.example.daily.dao;

import com.example.daily.entity.Exercise;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExerciseDao extends JpaRepository<Exercise, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "insert into exercise (email, date, duration, exercise_name)"
			 + "values( :email, :date, :duration, :exerciseName)" , nativeQuery = true)
	public void insertExercise(//			
			@Param("email") String email,//
			@Param("date")LocalDate date, //
			@Param("duration")int duration, //
			@Param("exerciseName")String exerciseName);//
}
