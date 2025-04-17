package com.example.daily.dao;


import com.example.daily.entity.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepDao extends JpaRepository<Sleep, Integer> {
}
