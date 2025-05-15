package com.example.daily.controller;

import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.MealsService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class MealsServiceController {
	
	@Autowired
	private MealsService mealsService;
	
	@PostMapping(value ="meals/fill_in_meals")
	public BasicRes fillInMeals(@Valid @RequestBody MealsReq req) {
		return mealsService.fillInMeals(req);
	}

	@PostMapping(value ="meals/update_meals")
	public BasicRes updateMeals(@Valid @RequestBody UpdateMealsReq req) {
		return mealsService.updateMeals(req);
	}

	@PostMapping(value ="meals/get_meals")
	public GetMealsRes getMeals(@Valid @RequestBody GetUserDataReq req) {
		return mealsService.getMeals(req);
	}
	
	@PostMapping(value ="meals/get_date_meals")
	public GetMealsRes getDateMeals(@Valid @RequestBody GetDateMealsReq req) {
		return mealsService.getDateMeals(req);
	}

	@PostMapping(value ="meals/delete_meals")
	public BasicRes deleteMeals(@Valid @RequestBody DeleteMealsReq req) {
		return mealsService.deleteMeals(req);
	}
}