package com.example.daily.service.impl;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.FoodDao;
import com.example.daily.entity.Food;
import com.example.daily.service.ifs.FoodService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.FoodReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;


    @Override
    public BasicRes foodInsert(FoodReq req) {
        // 檢查食物是否已存在
        Food foodName = foodDao.getByFoodName(req.getFoodName(),req.getCookingMethod());
        // 食物已存在
        if (foodName != null){
            return new BasicRes(ResMessage.FOOD_EXISTED.getCode(),//
                    ResMessage.FOOD_EXISTED.getMessage());
        }
        // 新增食物
        foodDao.insert(req.getFoodName(), req.getCookingMethod(), req.getType(), req.getCalorie(),
                req.getTotalFat(), req.getTransFat(), req.getSaturatedFat(), req.getTotalCarbohydrate(),
                req.getSugar(), req.getDietaryFiber(), req.getProtein(), req.getSodium(),
                req.getCholesterol());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes foodUpdate(FoodReq req) {
        // 檢查食物是否已存在
        Food foodName = foodDao.getByFoodName(req.getFoodName(),req.getCookingMethod());
        // 食物不存在
        if (foodName == null){
            return new BasicRes(ResMessage.FOOD_NOT_EXISTED.getCode(),//
                    ResMessage.FOOD_NOT_EXISTED.getMessage());
        }
        foodDao.updateFood(req.getFoodName(), req.getCookingMethod(), req.getType(), req.getCalorie(),
                req.getTotalFat(), req.getTransFat(), req.getSaturatedFat(), req.getTotalCarbohydrate(),
                req.getSugar(), req.getDietaryFiber(), req.getProtein(), req.getSodium(),
                req.getCholesterol());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes deleteFood(FoodReq req) {
        // 檢查食物是否已存在
        Food foodName = foodDao.getByFoodName(req.getFoodName(),req.getCookingMethod());
        // 食物不存在
        if (foodName == null){
            return new BasicRes(ResMessage.FOOD_NOT_EXISTED.getCode(),//
                    ResMessage.FOOD_NOT_EXISTED.getMessage());
        }
        foodDao.delete(req.getFoodName(), req.getCookingMethod());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }
}
