package com.example.daily.dao;

import com.example.daily.entity.Sports;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsDao extends JpaRepository<Sports, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into sports (sports_name, sports_type, consume )"
            + "values( :sportsName, :sports_type, :consume )" , nativeQuery = true)
    public void insertSports(//
                             @Param("sportsName") String sportsName,//
                             @Param("sports_type") String sports_type, //
                             @Param("consume")int consume//
    );
}
