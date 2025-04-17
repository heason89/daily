package com.example.daily.dao;

import com.example.daily.entity.Food;
import com.example.daily.entity.FoodId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDao extends JpaRepository<Food, FoodId> {
}
