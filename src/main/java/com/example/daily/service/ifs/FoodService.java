package com.example.daily.service.ifs;

import com.example.daily.vo.BasicRes;
import com.example.daily.vo.FoodReq;
import com.example.daily.vo.GetFoodRes;

public interface FoodService {
    public BasicRes foodInsert(FoodReq req);

    public BasicRes foodUpdate(FoodReq req);

    public BasicRes deleteFood(FoodReq req);
    
    public GetFoodRes selectFood(FoodReq req);
}
