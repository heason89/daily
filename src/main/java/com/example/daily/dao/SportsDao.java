package com.example.daily.dao;

import com.example.daily.entity.Sports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsDao extends JpaRepository<Sports, String> {
}
