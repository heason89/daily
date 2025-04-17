package com.example.daily.dao;

import com.example.daily.entity.Mood;
import com.example.daily.entity.MoodId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodDao extends JpaRepository<Mood, MoodId> {
}
