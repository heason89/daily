package com.example.daily.service.ifs;

import com.example.daily.vo.*;

public interface FoodService {
    public BasicRes insertFood(FoodReq req);

    public BasicRes updateFood(FoodReq req);

    public BasicRes deleteFood(DeleteFoodReq req);
    
    public GetFoodRes searchFood(SearchFoodReq req);

    public GetFoodRes getAllFood();
}
