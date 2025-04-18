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
public interface UserDao extends JpaRepository<User, String> {

    @Query(value ="select * from user where email = ?1", nativeQuery =true)
    public User getByEmail(String email);

    @Modifying
    @Transactional
    @Query(value ="insert into user(user_name, email, password, admin, active, age, height, weight, " +
            "work_type, gender) values (:name, :email, :password, :admin, :active, :age, :height, " +
            " :weight, :workType, :gender)", nativeQuery =true)
    public void insert(
            @Param("name") String name,//
            @Param("email") String email,//
            @Param("password") String password,//
            @Param("admin")Boolean admin,//
            @Param("active") Boolean active,//
            @Param("age")Integer age,//
            @Param("height")Integer height,//
            @Param("weight")Integer weight,//
            @Param("workType") String workType,//
            @Param("gender")Boolean gender);

    @Modifying
    @Transactional
    @Query(value ="update user set user_name = :name, password = :password, admin = :admin, " +
            " active = :active, age = :age, height = :height, weight = :weight, work_type = :workType, " +
            " gender = :gender where email = :email", nativeQuery =true)
    public void updateUser(
            @Param("name") String name,//
            @Param("email") String email,//
            @Param("password") String password,//
            @Param("admin")Boolean admin,//
            @Param("active") Boolean active,//
            @Param("age")Integer age,//
            @Param("height")Integer height,//
            @Param("weight")Integer weight,//
            @Param("workType") String workType,//
            @Param("gender")Boolean gender);
}
