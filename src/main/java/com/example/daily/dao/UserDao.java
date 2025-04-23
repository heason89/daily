package com.example.daily.dao;

import com.example.daily.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Query(value ="select * from user where email = ?1", nativeQuery =true)
    public User getByEmail(String email);

    @Modifying
    @Transactional
    @Query(value ="insert into user(user_name, email, password, admin, active, birthdate, height, " +
            " weight, work_type, gender, token, token_expiry, photo, note) values (:name, :email, " +
            " :password, :admin, :active, :birthdate, :height, :weight, :workType, :gender, " +
            " :token, :tokenExpiry, :photo, :note)", nativeQuery =true)
    public void insert(
            @Param("name") String name,//
            @Param("email") String email,//
            @Param("password") String password,//
            @Param("admin")Boolean admin,//
            @Param("active") Boolean active,//
            @Param("birthdate")LocalDate birthdate,//
            @Param("height")int height,//
            @Param("weight")int weight,//
            @Param("workType") String workType,//
            @Param("gender")String gender,//
            @Param("token") String token,//
            @Param("tokenExpiry") LocalDateTime tokenExpiry,//
            @Param("photo")String photo,//
            @Param("note")String note);

    @Modifying
    @Transactional
    @Query(value ="update user set user_name = :name, password = :password, admin = :admin, " +
            " active = :active, birthdate = :birthdate, height = :height, weight = :weight, " +
            " work_type = :workType, gender = :gender note = :note  where email = :email",
            nativeQuery =true)
    public void updateUserInfo(
            @Param("name") String name,//
            @Param("email") String email,//
            @Param("password") String password,//
            @Param("admin")Boolean admin,//
            @Param("active") Boolean active,//
            @Param("birthdate")LocalDate birthdate,//
            @Param("height")int height,//
            @Param("weight")int weight,//
            @Param("workType") String workType,//
            @Param("gender")String gender,//
            @Param("note")String note);

    @Modifying
    @Transactional
    @Query(value ="update user set user_name = :name, password = :password, admin = :admin, " +
            " active = :active, birthdate = :birthdate, height = :height, weight = :weight, " +
            " work_type = :workType, gender = :gender, token = :token, token_expiry = :tokenExpiry, " +
            " photo = :photo, note = :note where email = :email", nativeQuery =true)
    public void updateUserAndToken(
            @Param("name") String name,//
            @Param("email") String email,//
            @Param("password") String password,//
            @Param("admin")Boolean admin,//
            @Param("active") Boolean active,//
            @Param("birthdate")LocalDate birthdate,//
            @Param("height")int height,//
            @Param("weight")int weight,//
            @Param("workType") String workType,//
            @Param("gender")String gender,//
            @Param("token") String token,//
            @Param("tokenExpiry") LocalDateTime tokenExpiry,//
            @Param("photo")String photo,//
            @Param("note")String note);

    @Modifying
    @Transactional
    @Query(value ="update user set password = ?2, where email = ?1", nativeQuery =true)
    public void resetPassword(String email, String password);

    @Modifying
    @Transactional
    @Query(value ="update user set active = true, token = null where email = ?1", nativeQuery =true)
    public void updateActive(String email);

    @Modifying
    @Transactional
    @Query(value ="update user set photo = ?2 where email = ?1", nativeQuery =true)
    public void updatePhoto(String email,String photo);
}
