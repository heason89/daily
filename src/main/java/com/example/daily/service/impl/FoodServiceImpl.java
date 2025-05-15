package com.example.daily.service.impl;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.FoodDao;
import com.example.daily.entity.Food;
import com.example.daily.service.ifs.FoodService;
import com.example.daily.vo.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;

    @Override
    public BasicRes insertFood(FoodReq req) {
        // 檢查食物是否已存在
        Food foodName = foodDao.getByFoodName(req.getFoodName(),req.getCookingMethod());
        // 食物已存在
        if (foodName != null){
            return new BasicRes(ResMessage.FOOD_EXISTED.getCode(),//
                    ResMessage.FOOD_EXISTED.getMessage());
        }
        // 新增食物
        foodDao.insertFood(req.getFoodName(), req.getCookingMethod(), req.getType(), req.getCalorie(),
                req.getTotalFat(), req.getTransFat(), req.getSaturatedFat(), req.getTotalCarbohydrate(),
                req.getSugar(), req.getDietaryFiber(), req.getProtein(), req.getSodium(),
                req.getCholesterol(), req.getPhoto(),req.getUnit());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes updateFood(FoodReq req) {
        // 檢查食物是否已存在
        Food foodName = foodDao.getByFoodName(req.getFoodName(),req.getCookingMethod());
        // 食物不存在
        if (foodName == null){
            return new BasicRes(ResMessage.FOOD_NOT_EXISTED.getCode(),//
                    ResMessage.FOOD_NOT_EXISTED.getMessage());
        }
        // 更新食物
        foodDao.updateFood(req.getFoodName(), req.getCookingMethod(), req.getType(), req.getCalorie(),
                req.getTotalFat(), req.getTransFat(), req.getSaturatedFat(), req.getTotalCarbohydrate(),
                req.getSugar(), req.getDietaryFiber(), req.getProtein(), req.getSodium(),
                req.getCholesterol(), req.getPhoto(),req.getUnit());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes deleteFood(DeleteFoodReq req) {
        // 檢查食物是否已存在
        Food foodName = foodDao.getByFoodName(req.getFoodName(),req.getCookingMethod());
        // 食物不存在
        if (foodName == null){
            return new BasicRes(ResMessage.FOOD_NOT_EXISTED.getCode(),//
                    ResMessage.FOOD_NOT_EXISTED.getMessage());
        }
        // 刪除食物
        foodDao.deleteFood(req.getFoodName(), req.getCookingMethod());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    // 搜尋食物
	@Override
	public GetFoodRes searchFood(SearchFoodReq req) {
		List<Food> list = foodDao.searchFood(req.getFoodName(), req.getCookingMethod(), req.getType());
		 return new GetFoodRes(ResMessage.SUCCESS.getCode(),//
	                ResMessage.SUCCESS.getMessage(),list);
	}

    // 取得所有食物
    @Override
    public GetFoodRes getAllFood() {
        List<Food> list = foodDao.getAllFood();
        return new GetFoodRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage(),list);
    }
}
