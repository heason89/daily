package com.example.daily.dao;

import com.example.daily.entity.Food;
import com.example.daily.entity.FoodId;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FoodDao extends JpaRepository<Food, FoodId> {

    @Query(value ="select * from food where food_name = ?1 and cooking_method = ?2 ", nativeQuery =true)
    public Food getByFoodName(String foodName, String cookingMethod);

    @Modifying
    @Transactional
    @Query(value ="insert into food(food_name, cooking_method, type, calorie, total_fat, trans_fat, " +
            " saturated_fat, total_carbohydrate, sugar, dietary_fiber, protein, sodium, cholesterol, photo) " +
            " values (:foodName, :cookingMethod, :type, :calorie, :totalFat, :transFat, :saturatedFat, " +
            " :totalCarbohydrate, :sugar, :dietaryFiber, :protein, :sodium, :cholesterol, :photo, :unit)"
            , nativeQuery =true)
    public void insertFood(
            @Param("foodName") String foodName,//
            @Param("cookingMethod") String cookingMethod,//
            @Param("type") String type,//
            @Param("calorie")int calorie,//
            @Param("totalFat") double totalFat,//
            @Param("transFat")double transFat,//
            @Param("saturatedFat")double saturatedFat,//
            @Param("totalCarbohydrate")double totalCarbohydrate,//
            @Param("sugar") double sugar,//
            @Param("dietaryFiber")double dietaryFiber,//
            @Param("protein")double protein,//
            @Param("sodium")int sodium,//
            @Param("cholesterol")int cholesterol,//
            @Param("photo") String photo,//
            @Param("unit") String unit//
            );
    		
    @Modifying
    @Transactional
    @Query(value ="update food set food_name = :foodName, cooking_method = :cookingMethod, " +
            " type = :type, calorie = :calorie, total_fat = :totalFat, trans_fat = :transFat, " +
            " saturated_fat = :saturatedFat, total_carbohydrate = :totalCarbohydrate, sugar = :sugar, " +
            " dietary_fiber = :dietaryFiber, protein = :protein, sodium = :sodium, " +
            " cholesterol = :cholesterol, photo = :photo where food_name = :foodName  and " +
            " cooking_method = :cookingMethod", nativeQuery =true)
    public void updateFood(
            @Param("foodName") String foodName,//
            @Param("cookingMethod") String cookingMethod,//
            @Param("type") String type,//
            @Param("calorie")int calorie,//
            @Param("totalFat")double totalFat,//
            @Param("transFat")double transFat,//
            @Param("saturatedFat")double saturatedFat,//
            @Param("totalCarbohydrate")double totalCarbohydrate,//
            @Param("sugar") double sugar,//
            @Param("dietaryFiber")double dietaryFiber,//
            @Param("protein")double protein,//
            @Param("sodium")int sodium,//
            @Param("cholesterol")int cholesterol,//
            @Param("photo") String photo,//
            @Param("unit") String unit//
            );

    @Modifying
    @Transactional
    @Query(value ="delete from food where food = ?1 and cooking_method = ?2 ", nativeQuery =true)
    public void deleteFood(String foodName, String cookingMethod);
    
    @Query(value="select * from food where food_name like %?1% and cooking_method like %?2% " +
            " and type like %?3%",nativeQuery = true)
	public List<Food> searchFood(String foodName, String cookingMethod,String type);

    @Query(value="select * from food",nativeQuery = true)
    public List<Food> getAllFood();
}
