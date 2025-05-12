package com.example.daily.dao;

import com.example.daily.entity.Secret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretDao extends JpaRepository<Secret,Integer> {

    @Query(value ="select * from secret where id = 1", nativeQuery =true)
    public Secret getSecret();
}
