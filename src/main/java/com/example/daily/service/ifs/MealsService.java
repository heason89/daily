package com.example.daily.service.ifs;

import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MealsReq;
import com.example.daily.vo.SelectMealsRes;
import com.example.daily.vo.UpdateMealsReq;


public interface MealsService {
	
	public BasicRes fillinMeals(MealsReq  req);
	
	public SelectMealsRes SelectMeals(MealsReq  req);
	
	public BasicRes updateByMeals(UpdateMealsReq  req);

}
