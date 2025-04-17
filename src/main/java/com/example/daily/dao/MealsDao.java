package com.example.daily.dao;

import com.example.daily.entity.Meals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsDao extends JpaRepository<Meals, Integer> {
}
