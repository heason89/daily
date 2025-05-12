package com.example.daily.dao;

import com.example.daily.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value ="select * from user where email = ?1", nativeQuery =true)
    public User getByEmail(String email);

    @Query(value ="select * from user where user_id = ?1", nativeQuery =true)
    public User getByUserId(int userId);

    @Modifying
    @Transactional
    @Query(value ="update user set version = ?2 where user_id =?1", nativeQuery =true)
    public void updateVersion(int userId,int version);

    @Modifying
    @Transactional
    @Query(value ="insert into user(user_name, email, password, admin, enable, birthdate, height, " +
            " weight, work_type, gender, photo, note, body_type, version) values (:name, :email, " +
            " :password, :admin, :enable, :birthdate, :height, :weight, :workType, :gender, " +
            " :photo, :note, :bodyType, :version)", nativeQuery =true)
    public void insert(
            @Param("name") String name,//
            @Param("email") String email,//
            @Param("password") String password,//
            @Param("admin")Boolean admin,//
            @Param("enable") Boolean enable,//
            @Param("birthdate")LocalDate birthdate,//
            @Param("height")int height,//
            @Param("weight")int weight,//
            @Param("workType") String workType,//
            @Param("gender")String gender,//
            @Param("photo")String photo,//
            @Param("note")String note,//
            @Param("bodyType")String bodyType,//
            @Param("version")int version);

    @Modifying
    @Transactional
    @Query(value ="update user set user_name = :name, password = :password, admin = :admin, " +
            " enable = :enable, birthdate = :birthdate, height = :height, weight = :weight, " +
            " work_type = :workType, gender = :gender, photo = :photo, note = :note, " +
            " body_type = :bodyType, version = :version where email = :email",
            nativeQuery =true)
    public void updateNotEnableEmail(
            @Param("name") String name,//
            @Param("email") String email,//
            @Param("password") String password,//
            @Param("admin") Boolean admin,//
            @Param("enable") Boolean enable,//
            @Param("birthdate") LocalDate birthdate,//
            @Param("height") int height,//
            @Param("weight") int weight,//
            @Param("workType") String workType,//
            @Param("gender") String gender,//
            @Param("photo") String photo,//
            @Param("note") String note,//
            @Param("bodyType") String bodyType,//
            @Param("version") int version);

    @Modifying
    @Transactional
    @Query(value ="update user set user_name = :name, password = :password, admin = :admin, " +
            " enable = :enable, birthdate = :birthdate, height = :height, weight = :weight, " +
            " work_type = :workType, gender = :gender, photo = :photo, note = :note, " +
            " body_type = :bodyType, version = :version where user_id = :userId",
            nativeQuery =true)
    public void updateUserInfo(
            @Param("userId") int userId,//
            @Param("name") String name,//
            @Param("password") String password,//
            @Param("admin")Boolean admin,//
            @Param("enable") Boolean enable,//
            @Param("birthdate")LocalDate birthdate,//
            @Param("height")int height,//
            @Param("weight")int weight,//
            @Param("workType") String workType,//
            @Param("gender")String gender,//
            @Param("photo")String photo,//
            @Param("note")String note,//
            @Param("bodyType")String bodyType,//
            @Param("version")int version);

    @Modifying
    @Transactional
    @Query(value ="update user set password = ?2 where email = ?1", nativeQuery =true)
    public void resetPassword(String email, String password,int version);

    @Modifying
    @Transactional
    @Query(value ="update user set enable = true where email = ?1", nativeQuery =true)
    public void updateEnable(String email);
}
