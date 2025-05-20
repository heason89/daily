package com.example.daily.service.ifs;

import com.example.daily.vo.NutritionRes;

public interface NutritionService {
	
	NutritionRes getNutritionByFood(String foodName);

}
