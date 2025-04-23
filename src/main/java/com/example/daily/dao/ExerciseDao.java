package com.example.daily.dao;

import com.example.daily.entity.Exercise;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseDao extends JpaRepository<Exercise, Integer> {

	@Modifying
	@Transactional
	@Query(value = "insert into exercise (email, date, duration, exercise_name)"
			+ "values( :email, :date, :duration, :exerciseName)" , nativeQuery = true)
	public void insertExercise(//
							   @Param("email") String email,//
							   @Param("date") LocalDate date, //
							   @Param("duration")int duration, //
							   @Param("exerciseName")String exerciseName);//

	@Modifying
	@Transactional
	@Query(value="update exercise set date = :date, duration = :duration,"
			+ "exercise_name = :exerciseName where  exercise_id = :exerciseId"
			,nativeQuery = true)
	public void updateByExercise(//
								 @Param("exerciseId") int exerciseId, //
								 @Param("date")LocalDate date, //
								 @Param("duration")int duration,//
								 @Param("exerciseName")String exerciseName//
	);

	@Query(value="select count(email) from exercise where email = ?1 ",nativeQuery = true)
	public int selectCountByemail(String email);

	@Query(value="select * from exercise where email = ?1 ",nativeQuery = true)
	public List<Exercise> selectByemail(String email);

	@Query(value="select * from exercise  ",nativeQuery = true)
	public List<Exercise> select();
}
