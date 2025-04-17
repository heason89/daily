package com.example.daily.dao;

import com.example.daily.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseDao extends JpaRepository<Exercise, Integer> {
}
