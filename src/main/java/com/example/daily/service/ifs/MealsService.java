package com.example.daily.service.ifs;

import com.example.daily.vo.*;

public interface MealsService {
	
	public BasicRes fillInMeals(MealsReq  req);
	
	public GetMealsRes getMeals(GetUserDataReq req);
	
	public BasicRes updateMeals(UpdateMealsReq  req);
	
	public BasicRes deleteMeals(DeleteMealsReq  req);
	
	public GetMealsRes getDateMeals(GetDateMealsReq  req);
}
