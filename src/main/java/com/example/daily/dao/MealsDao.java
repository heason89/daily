package com.example.daily.dao;

import com.example.daily.entity.Meals;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MealsDao extends JpaRepository<Meals, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into meals (email, meals_name, eat_time )"
            + "values( :email, :mealsName, :eatTime )" , nativeQuery = true)
    public void insertMeals(//
                            @Param("email") String email,//
                            @Param("mealsName")String mealsName, //
                            @Param("eatTime") LocalDateTime eatTime);//

    @Query(value="select count(email) from meals where email = ?1 ",nativeQuery = true)
    public int selectCountByemail(String email);

    @Query(value="select * from meals where email = ?1 ",nativeQuery = true)
    public List<Meals> selectByemail(String email);

    @Modifying
    @Transactional
    @Query(value="update meals set meals_name = :mealsName, eat_time = :eatTime "
            + " where  meals_id = :mealsId"
            ,nativeQuery = true)
    public void updateByMeals(//
                              @Param("mealsId") int mealsId, //
                              @Param("mealsName")String mealsName, //
                              @Param("eatTime")LocalDateTime eatTime//
                              //
    );
}