package com.example.daily.dao;

import com.example.daily.entity.Sports;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsDao extends JpaRepository<Sports, String> {

	@Query(value ="select * from sports where sports_name = ?1", nativeQuery =true)
	public Sports getBySportsName(String sportsName);

	@Modifying
	@Transactional
	@Query(value = "insert into sports (sports_name, sports_type, consume)"
			 + "values(?1, ?2, ?3)" , nativeQuery = true)
	public void insertSports(String sportsName,String sports_type,int consume);

	@Modifying
	@Transactional
	@Query(value = "update sports set sports_name = ?1, sports_type = ?2, consume =?3 " +
			" where sports_name = ?1", nativeQuery = true)
	public void updateSports(String sportsName,String sports_type,int consume);

	@Modifying
	@Transactional
	@Query(value ="delete from sports where sports_name = ?1", nativeQuery =true)
	public void deleteSport(String sportsName);

	@Query(value="select * from sports where sports_name like %?1% and sports_type like %?2% ",nativeQuery = true)
	public List<Sports> searchSports(String sportsName,String sports_type);

	@Query(value="select * from sports",nativeQuery = true)
	public List<Sports> getAllSports();
}
