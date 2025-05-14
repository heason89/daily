package com.example.daily.service.impl;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.FoodDao;
import com.example.daily.entity.Food;
import com.example.daily.service.ifs.FoodService;
import com.example.daily.vo.*;

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
// 	@CacheEvict(cacheNames = "get_all", allEntries = true)
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
    // 清除暫存資料: 只有 cacheNames 沒有 key，會把 cacheNames 是 quiz_search 的所有暫存資料清除
 	// 如果是 cacheNames + key，則是只清除特定的暫存資料； key 的參數值一樣使用 #p0 來表示，但通常不會只清除特定資料
 	// allEntries: 強制刪除指定的 cacheNames 底下所有 key 對應的暫存資料，預設是 false
// 	@CacheEvict(cacheNames = "get_all", allEntries = true)
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
    // 清除暫存資料: 只有 cacheNames 沒有 key，會把 cacheNames 是 quiz_search 的所有暫存資料清除
 	// 如果是 cacheNames + key，則是只清除特定的暫存資料； key 的參數值一樣使用 #p0 來表示，但通常不會只清除特定資料
 	// allEntries: 強制刪除指定的 cacheNames 底下所有 key 對應的暫存資料，預設是 false
// 	@CacheEvict(cacheNames = "get_all", allEntries = true)
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
//    @Cacheable(cacheNames = "get_all", //
//			key = "#p0.foodName", //
//			unless = "#result.code != 200")
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
