package com.example.daily.dao;

import com.example.daily.entity.Mood;
import com.example.daily.entity.MoodId;

import jakarta.transaction.Transactional;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface MoodDao extends JpaRepository<Mood, MoodId> {
	
	@Modifying
	@Transactional
	@Query(value = "insert into mood(user_id, date, mood, diary )"
			 + "values(:userId, :date , :mood, :diary )" , nativeQuery = true)
	public void insertMood(
			@Param("userId")int userId, //
			@Param("date")LocalDate date,//			
			@Param("mood")int mood,//
			@Param("diary")String diary//						
			);
	
	@Modifying
	@Transactional
	@Query(value="update mood set mood = :mood, diary = :diary"
			+ " where  user_id = :userId and date = :date "
			,nativeQuery = true)
	public void updateByMood(//
			@Param("userId")int userId, //
			@Param("date")LocalDate date, //
			@Param("mood")int mood,//
			@Param("diary")String diary);
	
//	@Query(value="select count(email) from mood where email = ?1 ",nativeQuery = true)
//	public int selectCountByemail(String email);
	
	@Query(value="select * from mood where user_id = ?1 ",nativeQuery = true)
	public List<Mood> getAllMoodByUserId(int userId);
	
	@Query(value="select * from mood where user_id = ?1 and date = ?2",nativeQuery = true)
	public Mood getMoodByUserIdDate(int userId, LocalDate date);

	@Modifying
	@Transactional
	@Query(value="delete from mood where user_id = ?1 and date = ?2 ",nativeQuery = true)
	public void deleteMood(int userId, LocalDate date);
	
	@Query(value="select * from mood where user_id = ?1 and date like 2025-?2%",nativeQuery = true)
	public List<Mood> getMoodByUserIdMonth(int userId, String month);
}
