package com.example.daily.dao;


import com.example.daily.entity.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderDao extends JpaRepository<Sender, String> {
    @Query(value ="select * from sender", nativeQuery =true)
    public Sender getSender();
}