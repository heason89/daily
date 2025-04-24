package com.example.daily.service.impl;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.FoodDao;
import com.example.daily.entity.Food;
import com.example.daily.entity.Meals;
import com.example.daily.service.ifs.FoodService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.FoodReq;
import com.example.daily.vo.GetFoodRes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;
    // 清除暫存資料: 只有 cacheNames 沒有 key，會把 cacheNames 是 quiz_search 的所有暫存資料清除
 	// 如果是 cacheNames + key，則是只清除特定的暫存資料； key 的參數值一樣使用 #p0 來表示，但通常不會只清除特定資料
 	// allEntries: 強制刪除指定的 cacheNames 底下所有 key 對應的暫存資料，預設是 false
 	@CacheEvict(cacheNames = "get_all", allEntries = true)
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
                req.getCholesterol(), req.getPhoto());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }
    // 清除暫存資料: 只有 cacheNames 沒有 key，會把 cacheNames 是 quiz_search 的所有暫存資料清除
 	// 如果是 cacheNames + key，則是只清除特定的暫存資料； key 的參數值一樣使用 #p0 來表示，但通常不會只清除特定資料
 	// allEntries: 強制刪除指定的 cacheNames 底下所有 key 對應的暫存資料，預設是 false
 	@CacheEvict(cacheNames = "get_all", allEntries = true)
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
                req.getCholesterol(), req.getPhoto());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }
    // 清除暫存資料: 只有 cacheNames 沒有 key，會把 cacheNames 是 quiz_search 的所有暫存資料清除
 	// 如果是 cacheNames + key，則是只清除特定的暫存資料； key 的參數值一樣使用 #p0 來表示，但通常不會只清除特定資料
 	// allEntries: 強制刪除指定的 cacheNames 底下所有 key 對應的暫存資料，預設是 false
 	@CacheEvict(cacheNames = "get_all", allEntries = true)
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
    @Cacheable(cacheNames = "get_all", //
			key = "#p0.foodName ", //			
			unless = "#result.code != 200")
	@Override
	public GetFoodRes selectFood(FoodReq req) {
		List<Food> list = foodDao.selectFood(req.getFoodName());
		 return new GetFoodRes(ResMessage.SUCCESS.getCode(),//
	                ResMessage.SUCCESS.getMessage(),list);
	}
}
