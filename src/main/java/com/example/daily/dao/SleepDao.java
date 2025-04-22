package com.example.daily.dao;



import com.example.daily.entity.Sleep;

import jakarta.transaction.Transactional;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepDao extends JpaRepository<Sleep, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "insert into sleep (email,sleep_time,awake_time, insomnia, sleep_latency, phone)"
			 + "values( :email, :sleepTime, :awakeTime, :insomnia, :sleepLatency, :phone)" , nativeQuery = true)
	public void insertSleep(//			
			@Param("email") String email,//
			@Param("sleepTime")LocalDateTime sleepTime, //
			@Param("awakeTime")LocalDateTime awakeTime,//
			@Param("insomnia")boolean insomnia,//
			@Param("sleepLatency")boolean sleepLatency,//
	        @Param("phone")boolean phone);
	
	@Query(value="select count(email) from sleep where email = ?1 ",nativeQuery = true)
	public int selectCountByemail(String email);
	
	@Modifying
	@Transactional
	@Query(value="update sleep set sleep_time = :sleepTime, awake_time = :awakeTime,"
			+ " insomnia = :insomnia, sleep_latency = :sleepLatency, phone = :phone"
			+ " where  sleep_id = :sleepId"
			,nativeQuery = true)
	public void updateBySleep(//
			@Param("sleepId") int sleepId, //			
			@Param("sleepTime")LocalDateTime sleepTime, //
			@Param("awakeTime")LocalDateTime awakeTime,//
			@Param("insomnia")boolean insomnia,//
			@Param("sleepLatency")boolean sleepLatency,//
			@Param("phone")boolean phone//
			);
	
	
	
	@Query(value="select * from sleep where email = ?1 ",nativeQuery = true)
	public List<Sleep> selectByemail(String email);
}
