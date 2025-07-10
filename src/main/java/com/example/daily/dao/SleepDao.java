package com.example.daily.dao;

import com.example.daily.entity.Sleep;

import jakarta.transaction.Transactional;

import java.time.LocalDate;

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
	@Query(value = "insert into sleep (user_id, date, insomnia, sleep_latency, phone, hours)"
			+ "values( :userId, :date, :insomnia, :sleepLatency, :phone, :hours)", nativeQuery = true)
	public void insertSleep(//
			@Param("userId") int userId, //
			@Param("date") LocalDate date, //
			@Param("insomnia") boolean insomnia, //
			@Param("sleepLatency") boolean sleepLatency, //
			@Param("phone") boolean phone, //
			@Param("hours") double hours);

	@Modifying
	@Transactional
	@Query(value = "update sleep set sleep_time = :sleepTime, awake_time = :awakeTime,"
			+ " insomnia = :insomnia, sleep_latency = :sleepLatency, phone = :phone,"
			+ " hours = :hours where  sleep_id = :sleepId", nativeQuery = true)
	public void updateSleep(//
			@Param("sleepId") int sleepId, //
			@Param("date") LocalDate date, //
			@Param("insomnia") boolean insomnia, //
			@Param("sleepLatency") boolean sleepLatency, //
			@Param("phone") boolean phone, //
			@Param("hours") double hours);

	@Modifying
	@Transactional
	@Query(value = "delete from sleep where sleep_id = ?1 and user_id = ?2 ", nativeQuery = true)
	public void deleteSleep(int sleepId, int userId);

	@Query(value = "select * from sleep where user_id = ?1 ", nativeQuery = true)
	public List<Sleep> GetAllByUserId(int userId);

	@Query(value = "select * from sleep where user_id = ?1 and date = ?2", nativeQuery = true)
	public Sleep GetSleepByDate(int userId, LocalDate date);

	@Query(value = "select * from sleep where sleep_id = ?1 and user_id = ?2 ", nativeQuery = true)
	public Sleep GetBySleepId(int sleepId, int userId);
}
