package com.example.daily.dao;

import com.example.daily.entity.Food;
import com.example.daily.entity.FoodId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FoodDao extends JpaRepository<Food, FoodId> {

    @Query(value ="select * from food where food = ?1 and cooking_method = ?2 ", nativeQuery =true)
    public Food getByFoodName(String foodName, String cookingMethod);

    @Modifying
    @Transactional
    @Query(value ="insert into food(food_name, cooking_method, type, calorie, total_fat, trans_fat, " +
            " saturated_fat, total_carbohydrate, sugar, dietary_fiber, protein, sodium, cholesterol) " +
            " values (:foodName, :cookingMethod, :type, :calorie, :totalFat, :transFat, :saturatedFat, " +
            " :totalCarbohydrate, :sugar, :dietaryFiber, :protein, :sodium, :cholesterol)"
            , nativeQuery =true)
    public void insert(
            @Param("foodName") String foodName,//
            @Param("cookingMethod") String cookingMethod,//
            @Param("type") String type,//
            @Param("calorie")int calorie,//
            @Param("totalFat") int totalFat,//
            @Param("transFat")int transFat,//
            @Param("saturatedFat")int saturatedFat,//
            @Param("totalCarbohydrate")int totalCarbohydrate,//
            @Param("sugar") int sugar,//
            @Param("dietaryFiber")int dietaryFiber,//
            @Param("protein")int protein,//
            @Param("sodium")int sodium,//
            @Param("cholesterol")int cholesterol);

    @Modifying
    @Transactional
    @Query(value ="update food set food_name = :foodName, cooking_method = :cookingMethod, " +
            " type = :type, calorie = :calorie, total_fat = :totalFat, trans_fat = :transFat, " +
            " saturated_fat = :saturatedFat, total_carbohydrate = :totalCarbohydrate, sugar = :sugar, " +
            " dietary_fiber = :dietaryFiber, protein = :protein, sodium = :sodium, " +
            " cholesterol = :cholesterol, where foodName = :foodName  and " +
            " cooking_method = :cookingMethod", nativeQuery =true)
    public void updateFood(
            @Param("foodName") String foodName,//
            @Param("cookingMethod") String cookingMethod,//
            @Param("type") String type,//
            @Param("calorie")int calorie,//
            @Param("totalFat") int totalFat,//
            @Param("transFat")int transFat,//
            @Param("saturatedFat")int saturatedFat,//
            @Param("totalCarbohydrate")int totalCarbohydrate,//
            @Param("sugar") int sugar,//
            @Param("dietaryFiber")int dietaryFiber,//
            @Param("protein")int protein,//
            @Param("sodium")int sodium,//
            @Param("cholesterol")int cholesterol);

    @Modifying
    @Transactional
    @Query(value ="delete from food where food = ?1 and cooking_method = ?2 ", nativeQuery =true)
    public void delete(String foodName, String cookingMethod);
}
