package com.example.daily.dao;

import com.example.daily.entity.DailyFeedback;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyFeedbackDao extends JpaRepository<DailyFeedback, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into daily_feedback (user_id, date, feedback)"
            + "values( :userId, :date, :feedback)" , nativeQuery = true)
    public void insertDaily(//
            @Param("userId") int userId,//
            @Param("date") LocalDate date,//
            @Param("feedback")String feedback);

    @Query(value="select * from daily_feedback where user_id = ?1 ",nativeQuery = true)
    public List<DailyFeedback> getDailyByUserId(int userId);

    @Query(value="select * from daily_feedback where user_id = ?1 and date =?2",nativeQuery = true)
    public DailyFeedback getDailyByDate(int userId,LocalDate date);
}
